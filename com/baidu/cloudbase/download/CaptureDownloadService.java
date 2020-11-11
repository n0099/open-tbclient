package com.baidu.cloudbase.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.baidu.cloudbase.download.b;
import com.baidu.cloudbase.download.exception.DownloadException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class CaptureDownloadService extends Service {
    public static final String ACTION_CANCEL = "com.baidu.cloudar.download.ACTION_CANCEL";
    public static final String ACTION_CANCEL_ALL = "com.baidu.cloudar.download.ACTION_CANCEL_ALL";
    public static final String ACTION_DOWNLOAD = "com.baidu.cloudar.download.ACTION_DOWNLOAD";
    public static final String ACTION_DOWNLOAD_BROAD_CAST = "com.baidu.cloudar.download.ACTION_BROAD_CAST";
    public static final String ACTION_PAUSE = "com.baidu.cloudar.download.ACTION_PAUSE";
    public static final String ACTION_PAUSE_ALL = "com.baidu.cloudar.download.ACTION_PAUSE_ALL";
    public static final String EXTRA_FILE_INFO = "extra_file_info";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_TAG = "extra_tag";
    public static final String TAG = "CaptureDownloadService";
    public com.baidu.cloudbase.download.a mDownloadManager;

    /* loaded from: classes9.dex */
    public static class a extends com.baidu.cloudbase.download.a.a {
        public a.a.a.b.a amX;
        public int mLastProgress;
        public long mLastTime;
        public LocalBroadcastManager mLocalBroadcastManager;
        public int mPosition;

        public a(int i, a.a.a.b.a aVar, Context context) {
            this.mPosition = i;
            this.amX = aVar;
            this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(context);
        }

        private void a(a.a.a.b.a aVar) {
            Intent intent = new Intent();
            intent.setAction(CaptureDownloadService.ACTION_DOWNLOAD_BROAD_CAST);
            intent.putExtra("extra_position", this.mPosition);
            intent.putExtra("extra_file_info", aVar.a().toString());
            this.mLocalBroadcastManager.sendBroadcast(intent);
        }

        private boolean checkSendBroadLimit(int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastTime <= 300 || i == this.mLastProgress) {
                return false;
            }
            this.mLastTime = currentTimeMillis;
            this.mLastProgress = i;
            return true;
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void c(DownloadException downloadException) {
            downloadException.printStackTrace();
            a.a.a.b.a aVar = this.amX;
            aVar.g = 5;
            a(aVar);
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void onCompleted(String str) {
            a.a.a.b.a aVar = this.amX;
            aVar.g = 6;
            aVar.e = 100;
            aVar.h = str;
            a(aVar);
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void onDownloadCanceled() {
            a.a.a.b.a aVar = this.amX;
            aVar.g = 0;
            aVar.e = 0;
            aVar.f = "";
            a(aVar);
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void onDownloadPaused() {
            a.a.a.b.a aVar = this.amX;
            aVar.g = 4;
            a(aVar);
        }

        @Override // com.baidu.cloudbase.download.a.a
        public void onProgress(long j, long j2, int i) {
            if (this.mLastTime == 0) {
                this.mLastTime = System.currentTimeMillis();
            }
            a.a.a.b.a aVar = this.amX;
            aVar.g = 3;
            aVar.e = i;
            aVar.f = com.baidu.cloudbase.download.b.a.getDownloadPerSize(j, j2);
            if (checkSendBroadLimit(i)) {
                a(this.amX);
            }
        }
    }

    public static void cancel(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_CANCEL);
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    private void cancel(String str) {
        this.mDownloadManager.cancel(str);
    }

    private void cancelAll() {
        this.mDownloadManager.cancelAll();
    }

    public static void cancelAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_CANCEL_ALL);
        context.startService(intent);
    }

    public static void destroy(Context context) {
        context.stopService(new Intent(context, CaptureDownloadService.class));
    }

    private void download(int i, a.a.a.b.a aVar, String str) {
        this.mDownloadManager.a(new b.a().dt(aVar.d).uG(), str, new a(i, aVar, getApplicationContext()));
    }

    public static void pause(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_PAUSE);
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    private void pause(String str) {
        this.mDownloadManager.pause(str);
    }

    private void pauseAll() {
        this.mDownloadManager.pauseAll();
    }

    public static void pauseAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_PAUSE_ALL);
        context.startService(intent);
    }

    public static void start(Context context, int i, String str, a.a.a.b.a aVar) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra("extra_position", i);
        intent.putExtra("extra_tag", str);
        intent.putExtra("extra_file_info", aVar.a().toString());
        context.startService(intent);
    }

    public static void start(Context context, String str, a.a.a.b.a aVar) {
        start(context, 0, str, aVar);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDownloadManager = com.baidu.cloudbase.download.a.uF();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDownloadManager.pauseAll();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008e, code lost:
        if (r1.equals(com.baidu.cloudbase.download.CaptureDownloadService.ACTION_DOWNLOAD) != false) goto L8;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        char c = 0;
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = intent.getIntExtra("extra_position", 0);
            a.a.a.b.a aVar = new a.a.a.b.a();
            String stringExtra = intent.getStringExtra("extra_file_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    aVar.f952a = jSONObject.optString("name");
                    aVar.b = jSONObject.optString("id");
                    aVar.c = jSONObject.optString("image");
                    aVar.d = jSONObject.optString("url");
                    aVar.e = jSONObject.optInt("progress");
                    aVar.f = jSONObject.optString("downloadPerSize");
                    aVar.g = jSONObject.optInt("status");
                    aVar.h = jSONObject.optString("savePath");
                } catch (JSONException e) {
                }
            }
            String stringExtra2 = intent.getStringExtra("extra_tag");
            switch (action.hashCode()) {
                case -1845641145:
                    if (action.equals(ACTION_CANCEL_ALL)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1229466579:
                    if (action.equals(ACTION_PAUSE_ALL)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -540402171:
                    if (action.equals(ACTION_CANCEL)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1657148651:
                    if (action.equals(ACTION_PAUSE)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1915551059:
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    download(intExtra, aVar, stringExtra2);
                    break;
                case 1:
                    pause(stringExtra2);
                    break;
                case 2:
                    cancel(stringExtra2);
                    break;
                case 3:
                    pauseAll();
                    break;
                case 4:
                    cancelAll();
                    break;
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
