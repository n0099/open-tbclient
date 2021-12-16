package com.baidu.minivideo.plugin.capture.download.base;
/* loaded from: classes10.dex */
public interface Downloader {

    /* loaded from: classes10.dex */
    public interface OnDownloaderDestroyedListener {
        void onDestroyed(String str, Downloader downloader);
    }

    void cancel();

    boolean isRunning();

    void onDestroy();

    void pause();

    void start();
}
