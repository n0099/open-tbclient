package com.baidu.cyberplayer.sdk.videodownload;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
@Keep
/* loaded from: classes3.dex */
public class CyberVideoDownloader {

    @Keep
    /* loaded from: classes3.dex */
    public class DMDownloadError {
        public static final int Cust01 = 1901;
        public static final int Cust02 = 1902;
        public static final int Http400 = 1400;
        public static final int Http401 = 1401;
        public static final int Http403 = 1403;
        public static final int Http404 = 1404;
        public static final int Http499 = 1499;
        public static final int Http599 = 1599;
        public static final int Sys05 = 1605;
        public static final int Sys101 = 1701;
        public static final int Sys104 = 1704;
        public static final int Sys110 = 1710;
        public static final int Unknown = 1999;
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface DownloadListener {
        void onDataTransfer(String str, VideoDownloadBean videoDownloadBean);

        void operationCallback(String str, int i, int i2);
    }

    @Keep
    /* loaded from: classes3.dex */
    public class DownloadOperation {
        public static final int DELETE = 0;

        public DownloadOperation() {
        }
    }

    @Keep
    /* loaded from: classes3.dex */
    public class DownloadSubStatus {
        public static final int FILE_EXIST = 1;
        public static final int UNKNOWN = 0;

        public DownloadSubStatus() {
        }
    }

    @Keep
    /* loaded from: classes3.dex */
    public class DownloadTaskStatus {
        public static final int ABNORMAL_EXIT = 8;
        public static final int CANCELLED = 5;
        public static final int COMPLETE = 4;
        public static final int DELETED = 7;
        public static final int ERROR = 6;
        public static final int PAUSED = 3;
        public static final int PREPARED = 9;
        public static final int RUNNING = 2;
        public static final int UNKNOWN = 0;
        public static final int WAITING = 1;

        public DownloadTaskStatus() {
        }
    }

    public static void cancelDownload(String str) {
        d.f(str);
    }

    public static void deleteDownload(String str) {
        d.g(str);
    }

    public static void pauseDownload(String str) {
        d.e(str);
    }

    public static void setDownloadListener(DownloadListener downloadListener) {
        d.a(downloadListener);
    }

    public static void setWorkDir(String str) {
        d.d(str);
    }

    public static String startDownload(String str, VideoSourceBean videoSourceBean) {
        return d.a(str, videoSourceBean);
    }
}
