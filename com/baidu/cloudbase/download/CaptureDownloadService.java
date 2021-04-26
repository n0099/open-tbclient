package com.baidu.cloudbase.download;

import a.a.a.c.ac;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.cloudbase.download.exception.DownloadException;
import d.a.k.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
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
    public d.a.k.b.a mDownloadManager;

    /* loaded from: classes.dex */
    public static class a extends d.a.k.b.c.a {

        /* renamed from: a  reason: collision with root package name */
        public ac f4770a;

        /* renamed from: b  reason: collision with root package name */
        public int f4771b;

        /* renamed from: c  reason: collision with root package name */
        public long f4772c;

        /* renamed from: d  reason: collision with root package name */
        public LocalBroadcastManager f4773d;

        /* renamed from: e  reason: collision with root package name */
        public int f4774e;

        public a(int i2, ac acVar, Context context) {
            this.f4774e = i2;
            this.f4770a = acVar;
            this.f4773d = LocalBroadcastManager.getInstance(context);
        }

        public final boolean a(int i2) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f4772c <= 300 || i2 == this.f4771b) {
                return false;
            }
            this.f4772c = currentTimeMillis;
            this.f4771b = i2;
            return true;
        }

        public final void b(ac acVar) {
            Intent intent = new Intent();
            intent.setAction(CaptureDownloadService.ACTION_DOWNLOAD_BROAD_CAST);
            intent.putExtra("extra_position", this.f4774e);
            intent.putExtra("extra_file_info", acVar.a().toString());
            this.f4773d.sendBroadcast(intent);
        }

        @Override // d.a.k.b.c.a
        public void onCompleted(String str) {
            ac acVar = this.f4770a;
            acVar.f1408g = 6;
            acVar.f1406e = 100;
            acVar.f1409h = str;
            b(acVar);
        }

        @Override // d.a.k.b.c.a
        public void onDownloadCanceled() {
            ac acVar = this.f4770a;
            acVar.f1408g = 0;
            acVar.f1406e = 0;
            acVar.f1407f = "";
            b(acVar);
        }

        @Override // d.a.k.b.c.a
        public void onDownloadPaused() {
            ac acVar = this.f4770a;
            acVar.f1408g = 4;
            b(acVar);
        }

        @Override // d.a.k.b.c.a
        public void onFailed(DownloadException downloadException) {
            downloadException.printStackTrace();
            ac acVar = this.f4770a;
            acVar.f1408g = 5;
            b(acVar);
        }

        @Override // d.a.k.b.c.a
        public void onProgress(long j, long j2, int i2) {
            if (this.f4772c == 0) {
                this.f4772c = System.currentTimeMillis();
            }
            ac acVar = this.f4770a;
            acVar.f1408g = 3;
            acVar.f1406e = i2;
            acVar.f1407f = d.a.k.b.d.a.a(j, j2);
            if (a(i2)) {
                b(this.f4770a);
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
        this.mDownloadManager.c(str);
    }

    private void cancelAll() {
        this.mDownloadManager.d();
    }

    public static void cancelAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_CANCEL_ALL);
        context.startService(intent);
    }

    public static void destroy(Context context) {
        context.stopService(new Intent(context, CaptureDownloadService.class));
    }

    private void download(int i2, ac acVar, String str) {
        b.a aVar = new b.a();
        aVar.d(acVar.f1405d);
        this.mDownloadManager.f(aVar.a(), str, new a(i2, acVar, getApplicationContext()));
    }

    public static void pause(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_PAUSE);
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    private void pause(String str) {
        this.mDownloadManager.m(str);
    }

    private void pauseAll() {
        this.mDownloadManager.n();
    }

    public static void pauseAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_PAUSE_ALL);
        context.startService(intent);
    }

    public static void start(Context context, int i2, String str, ac acVar) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra("extra_position", i2);
        intent.putExtra("extra_tag", str);
        intent.putExtra("extra_file_info", acVar.a().toString());
        context.startService(intent);
    }

    public static void start(Context context, String str, ac acVar) {
        start(context, 0, str, acVar);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDownloadManager = d.a.k.b.a.i();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDownloadManager.n();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007e, code lost:
        if (r0.equals(com.baidu.cloudbase.download.CaptureDownloadService.ACTION_DOWNLOAD) != false) goto L8;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null) {
            String action = intent.getAction();
            char c2 = 0;
            int intExtra = intent.getIntExtra("extra_position", 0);
            ac acVar = new ac();
            String stringExtra = intent.getStringExtra("extra_file_info");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    acVar.f1402a = jSONObject.optString("name");
                    acVar.f1403b = jSONObject.optString("id");
                    acVar.f1404c = jSONObject.optString("image");
                    acVar.f1405d = jSONObject.optString("url");
                    acVar.f1406e = jSONObject.optInt("progress");
                    acVar.f1407f = jSONObject.optString("downloadPerSize");
                    acVar.f1408g = jSONObject.optInt("status");
                    acVar.f1409h = jSONObject.optString("savePath");
                } catch (JSONException unused) {
                }
            }
            String stringExtra2 = intent.getStringExtra("extra_tag");
            switch (action.hashCode()) {
                case -1845641145:
                    if (action.equals(ACTION_CANCEL_ALL)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1229466579:
                    if (action.equals(ACTION_PAUSE_ALL)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -540402171:
                    if (action.equals(ACTION_CANCEL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1657148651:
                    if (action.equals(ACTION_PAUSE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1915551059:
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                download(intExtra, acVar, stringExtra2);
            } else if (c2 == 1) {
                pause(stringExtra2);
            } else if (c2 == 2) {
                cancel(stringExtra2);
            } else if (c2 == 3) {
                pauseAll();
            } else if (c2 == 4) {
                cancelAll();
            }
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
