package com.baidu.down.manage;

import android.provider.BaseColumns;
/* loaded from: classes15.dex */
public final class DownloadConstants {
    public static final long CTRL_FLAG_AUTO_PAUSED = 2;
    public static final long CTRL_FLAG_CHECK_CONTENT_TYPE = 8;
    public static final long CTRL_FLAG_SUPPORT_RANGE = 1;
    public static final long CTRL_FLAG_WIFI_ONLY = 4;
    public static final int DOWNLOAD_PRIORITY_DEFAULT = 3;
    public static final int DOWNLOAD_THREAD_MAX_NUM = 3;
    public static final int DOWNLOAD_THREAD_MIN_NUM = 1;
    private static final boolean LOCAL_LOGVV = false;
    public static final boolean LOGV = true;
    public static final boolean LOGVV = false;
    public static final String LOG_TRACE_TAG = "core>download";
    public static final String MIMETYPE_APK = "application/vnd.android.package-archive";
    public static final String MIMETYPE_APK_PATCH = "application/com.baidu.appsearch.patch";
    public static final String MIMETYPE_GIF = "image/gif";
    public static final int PERCENT_HUNDERD = 100;
    public static final String REFER = "http://m.baidu.com";
    public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 499;
    public static final int STATUS_FILE_ERROR = 492;
    public static final int STATUS_PAUSED_BY_APP = 193;
    public static final int STATUS_PENDING = 190;
    public static final int STATUS_QUEUED_FOR_WIFI = 196;
    public static final int STATUS_RUNNING = 192;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_WAITING_FOR_NETWORK = 195;
    public static final int STATUS_WAITING_TO_RETRY = 194;
    public static final String TAG = "DownloadManager";
    public static final int VISIBILITY_VISIBLE = 0;
    public static boolean mDebug = false;
    private static String sDestinationDir;
    private static DestinationMode sDestinationMode;

    /* loaded from: classes15.dex */
    public enum DestinationMode {
        AUTO,
        INTERNAL_ONLY,
        EXTERNAL_ONLY,
        CUSTOM
    }

    private DownloadConstants() {
    }

    public static boolean isStatusError(int i) {
        return i >= 400 && i < 600;
    }

    /* loaded from: classes15.dex */
    public static final class DownloadColumns implements BaseColumns {
        public static final String COLUMN_AUTO_PAUSE = "AUTO_PAUSE";
        public static final String COLUMN_CONTROL_FLAG = "CONTROL_FLAG";
        public static final String COLUMN_CURRENT_BYTES = "CURRENT_BYTES";
        public static final String COLUMN_DOWNLOAD_PRIORITY = "DOWNLOAD_PRIORITY";
        public static final String COLUMN_DOWN_DIR = "DOWN_DIR";
        public static final String COLUMN_ETAG = "ETAG";
        public static final String COLUMN_FILE_NAME = "_DATA";
        public static final String COLUMN_FROM_PARAM = "FROM_PARAM";
        public static final String COLUMN_MIME_TYPE = "MIMETYPE";
        public static final String COLUMN_NEED_N_KEY = "NOTIFICATIONNEEDED";
        public static final String COLUMN_PROGRESS_MAP = "PROGRESSMAP";
        public static final String COLUMN_SAVED_PATH = "SAVED_PATH_FOR_USER";
        public static final String COLUMN_SOURCE_KEY = "SAVED_SOURCE_KEY_USER";
        public static final String COLUMN_STATUS = "STATUS";
        public static final String COLUMN_TOTAL_BYTES = "TOTAL_BYTES";
        public static final String COLUMN_URI = "URI";
        public static final String COLUMN_URI_HOST = "URI_HOST";
        public static final String FAILED_REASON = "FAILEDREASON";
        public static final String FAILED_TYPE = "FAILED_TYPE";

        private DownloadColumns() {
        }
    }

    public static void setDestinationMode(DestinationMode destinationMode) {
        sDestinationMode = destinationMode;
    }

    public static void setDestinationDir(String str) {
        sDestinationDir = str;
    }

    public static DestinationMode getDestinationMode() {
        return sDestinationMode != null ? sDestinationMode : DestinationMode.AUTO;
    }

    public static String getDestinationDir() {
        return sDestinationDir;
    }
}
