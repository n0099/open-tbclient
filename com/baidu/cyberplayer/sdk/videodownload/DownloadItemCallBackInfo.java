package com.baidu.cyberplayer.sdk.videodownload;

import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public class DownloadItemCallBackInfo {
    public static final int KEY_IS_DOWNLOAD_EVENT_COMPLETE = 102;
    public static final int KEY_IS_DOWNLOAD_EVENT_ERROR = 103;
    public static final int KEY_IS_DOWNLOAD_EVENT_PROGRESS = 100;
    public static final int KEY_IS_DOWNLOAD_EVENT_STATUE_CHANGED = 101;
    public static final int KEY_IS_DOWNLOAD_EVENT_UNKNOWN = 0;
    public DuMediaDownloadBean bean;
    public int errorCode;
    public String errorDetail;
    public int mEvent;
    public int percent;
    public int status;
    public String url;

    @Keep
    /* loaded from: classes3.dex */
    public class DownloadStatus {
        public static final int CANCELLED = 5;
        public static final int COMPLETE = 4;
        public static final int DELETE = 7;
        public static final int ERROR = 6;
        public static final int PAUSED = 3;
        public static final int RUNNING = 2;
        public static final int UNKNOWN = 0;
        public static final int WAITING = 1;

        public DownloadStatus() {
        }
    }

    public DownloadItemCallBackInfo(int i) {
        this.mEvent = 0;
        this.mEvent = i;
    }

    public int getEvent() {
        return this.mEvent;
    }
}
