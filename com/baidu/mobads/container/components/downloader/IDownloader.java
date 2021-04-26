package com.baidu.mobads.container.components.downloader;

import java.util.Observer;
/* loaded from: classes2.dex */
public interface IDownloader {
    public static final String TEMP_SUFFIX = ".tmp";

    /* loaded from: classes2.dex */
    public enum DownloadStatus {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");
        
        public int code;
        public String msg;

        DownloadStatus(int i2, String str) {
            this.code = i2;
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.msg;
        }
    }

    void addObserver(Observer observer);

    void cancel();

    int getFileSize();

    long getFileSizeLong();

    String getOutputPath();

    String getPackageName();

    float getProgress();

    DownloadStatus getState();

    String getTargetURL();

    String getURL();

    boolean isDownloadOnlyWifi();

    boolean isPausedManually();

    void pause();

    void removeObservers();

    void resume();

    void setDownloadOnlyWifi(boolean z);

    void setPausedManually(boolean z);

    void start();
}
