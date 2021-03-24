package com.baidu.minivideo.plugin.capture.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.minivideo.plugin.capture.download.DownloadRequest;
import com.baidu.minivideo.plugin.capture.download.base.DownloadCallback;
import com.baidu.minivideo.plugin.capture.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.utils.CommonUtils;
/* loaded from: classes2.dex */
public class CaptureDownloadService extends Service {
    public static final String ACTION_CANCEL = "com.baidu.ugc.download.ACTION_CANCEL";
    public static final String ACTION_CANCEL_ALL = "com.baidu.ugc.download.ACTION_CANCEL_ALL";
    public static final String ACTION_DOWNLOAD = "com.baidu.ugc.download.ACTION_DOWNLOAD";
    public static final String ACTION_DOWNLOAD_BROAD_CAST = "com.baidu.ugc.download.ACTION_BROAD_CAST";
    public static final String ACTION_PAUSE = "com.baidu.ugc.download.ACTION_PAUSE";
    public static final String ACTION_PAUSE_ALL = "com.baidu.ugc.download.ACTION_PAUSE_ALL";
    public static final String EXTRA_FILE_INFO = "extra_file_info";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_TAG = "extra_tag";
    public static final String TAG = "CaptureDownloadService";
    public DownloadManager mDownloadManager;

    /* loaded from: classes2.dex */
    public static class ProgressCallback extends DownloadCallback {
        public RequestTask mAppInfo;
        public int mLastProgress;
        public long mLastTime;
        public LocalBroadcastManager mLocalBroadcastManager;
        public int mPosition;

        public ProgressCallback(int i, RequestTask requestTask, Context context) {
            this.mPosition = i;
            this.mAppInfo = requestTask;
            this.mLocalBroadcastManager = LocalBroadcastManager.getInstance(context);
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

        private void sendBroadCast(RequestTask requestTask) {
            Intent intent = new Intent();
            intent.setAction(CaptureDownloadService.ACTION_DOWNLOAD_BROAD_CAST);
            intent.putExtra("extra_position", this.mPosition);
            intent.putExtra("extra_file_info", requestTask);
            this.mLocalBroadcastManager.sendBroadcast(intent);
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onCompleted(String str) {
            this.mAppInfo.setStatus(6);
            this.mAppInfo.setProgress(100);
            this.mAppInfo.setSavePath(str);
            sendBroadCast(this.mAppInfo);
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onDownloadCanceled() {
            this.mAppInfo.setStatus(0);
            this.mAppInfo.setProgress(0);
            this.mAppInfo.setDownloadPerSize("");
            sendBroadCast(this.mAppInfo);
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onDownloadPaused() {
            this.mAppInfo.setStatus(4);
            sendBroadCast(this.mAppInfo);
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onFailed(DownloadException downloadException) {
            downloadException.printStackTrace();
            this.mAppInfo.setStatus(5);
            sendBroadCast(this.mAppInfo);
        }

        @Override // com.baidu.minivideo.plugin.capture.download.base.DownloadCallback
        public void onProgress(long j, long j2, int i) {
            if (this.mLastTime == 0) {
                this.mLastTime = System.currentTimeMillis();
            }
            this.mAppInfo.setStatus(3);
            this.mAppInfo.setProgress(i);
            this.mAppInfo.setDownloadPerSize(CommonUtils.getDownloadPerSize(j, j2));
            if (checkSendBroadLimit(i)) {
                sendBroadCast(this.mAppInfo);
            }
        }
    }

    public static void cancel(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_CANCEL);
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    public static void cancelAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_CANCEL_ALL);
        context.startService(intent);
    }

    public static void destroy(Context context) {
        context.stopService(new Intent(context, CaptureDownloadService.class));
    }

    private void download(int i, RequestTask requestTask, String str) {
        this.mDownloadManager.download(new DownloadRequest.Builder().setUri(requestTask.getUrl()).build(), str, new ProgressCallback(i, requestTask, getApplicationContext()));
    }

    public static void pause(Context context, String str) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_PAUSE);
        intent.putExtra("extra_tag", str);
        context.startService(intent);
    }

    public static void pauseAll(Context context) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_PAUSE_ALL);
        context.startService(intent);
    }

    public static void start(Context context, String str, RequestTask requestTask) {
        start(context, 0, str, requestTask);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDownloadManager = DownloadManager.getInstance();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDownloadManager.pauseAll();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r0.equals(com.baidu.minivideo.plugin.capture.download.CaptureDownloadService.ACTION_DOWNLOAD) != false) goto L7;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            char c2 = 0;
            int intExtra = intent.getIntExtra("extra_position", 0);
            RequestTask requestTask = (RequestTask) intent.getSerializableExtra("extra_file_info");
            String stringExtra = intent.getStringExtra("extra_tag");
            switch (action.hashCode()) {
                case -2000112966:
                    if (action.equals(ACTION_CANCEL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1148652932:
                    if (action.equals(ACTION_CANCEL_ALL)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -929888424:
                    if (action.equals(ACTION_PAUSE_ALL)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -707184440:
                    break;
                case 1610061206:
                    if (action.equals(ACTION_PAUSE)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                download(intExtra, requestTask, stringExtra);
            } else if (c2 == 1) {
                pause(stringExtra);
            } else if (c2 == 2) {
                cancel(stringExtra);
            } else if (c2 == 3) {
                pauseAll();
            } else if (c2 == 4) {
                cancelAll();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    public static void start(Context context, int i, String str, RequestTask requestTask) {
        Intent intent = new Intent(context, CaptureDownloadService.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra("extra_position", i);
        intent.putExtra("extra_tag", str);
        intent.putExtra("extra_file_info", requestTask);
        context.startService(intent);
    }

    private void cancelAll() {
        this.mDownloadManager.cancelAll();
    }

    private void pauseAll() {
        this.mDownloadManager.pauseAll();
    }

    private void cancel(String str) {
        this.mDownloadManager.cancel(str);
    }

    private void pause(String str) {
        this.mDownloadManager.pause(str);
    }
}
