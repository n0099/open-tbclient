package com.baidu.cyberplayer.sdk;

import android.content.Context;
/* loaded from: classes.dex */
public class BEngineManager {
    public static final String RECEIVER_ENGINE_UPDATE = "com.baidu.cyberplayer.engine.UPDATE";

    /* loaded from: classes.dex */
    public interface OnEngineListener {
        public static final int DOWNLOAD_CANCEL = 2;
        public static final int DOWNLOAD_CONTINUE = 0;
        public static final int DOWNLOAD_STOP = 1;
        public static final int RET_CANCELED = 3;
        public static final int RET_FAILED_ALREADY_INSTALLED = 8;
        public static final int RET_FAILED_ALREADY_RUNNING = 6;
        public static final int RET_FAILED_INVALID_APK = 9;
        public static final int RET_FAILED_NETWORK = 5;
        public static final int RET_FAILED_OTHERS = 7;
        public static final int RET_FAILED_STORAGE_IO = 4;
        public static final int RET_NEW_PACKAGE_INSTALLED = 0;
        public static final int RET_NO_NEW_PACKAGE = 1;
        public static final int RET_STOPPED = 2;

        int onDownload(int i, int i2);

        void onInstalled(int i);

        int onPreInstall();

        boolean onPrepare();
    }

    /* loaded from: classes.dex */
    public class UpdateInfo {
        public String info;
        public String version;

        public UpdateInfo(String str, String str2) {
            this.version = str;
            this.info = str2;
        }
    }

    public void installAsync(OnEngineListener onEngineListener) {
        if (onEngineListener != null) {
            onEngineListener.onInstalled(7);
        }
    }

    public boolean initCyberPlayerEngine(String str, String str2) {
        return false;
    }

    public boolean EngineInstalled() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BEngineManager(Context context) {
    }
}
