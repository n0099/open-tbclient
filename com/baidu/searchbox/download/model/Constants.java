package com.baidu.searchbox.download.model;

import com.baidu.searchbox.download.ioc.DownloadRuntime;
/* loaded from: classes3.dex */
public final class Constants {
    public static final String ACTION_HIDE = "com.baidu.searchbox.intent.action.DOWNLOAD_HIDE";
    public static final String ACTION_LIST = "com.baidu.searchbox.intent.action.DOWNLOAD_LIST";
    public static final String ACTION_OPEN = "com.baidu.searchbox.intent.action.DOWNLOAD_OPEN";
    public static final String ACTION_RETRY = "com.baidu.searchbox.intent.action.DOWNLOAD_WAKEUP";
    public static final int BUFFER_SIZE = 4096;
    public static final boolean DEBUG = false;
    public static final String DEFAULT_DL_BINARY_EXTENSION = ".bin";
    public static final String DEFAULT_DL_FILENAME = "downloadfile";
    public static final String DEFAULT_DL_HTML_EXTENSION = ".html";
    public static final String DEFAULT_DL_SUBDIR = "/baidu/searchbox/downloads";
    public static final String DEFAULT_DL_SUBDIR_NAME = "downloads";
    public static final String DEFAULT_DL_TEXT_EXTENSION = ".txt";
    public static final String DEFAULT_USER_AGENT = "AndroidDownloadManager";
    public static final String ETAG = "etag";
    public static final String EXTRA_TYPE = "extra_type";
    public static final String FAILED_CONNECTIONS = "numfailed";
    public static final String FILENAME_SEQUENCE_SEPARATOR = "-";
    public static final String KNOWN_SPURIOUS_FILENAME = "lost+found";
    public static final boolean LOCAL_LOGVV;
    public static final boolean LOGV;
    public static final boolean LOGVV;
    public static final boolean LOGX;
    public static final int MAX_DOWNLOADS = 21000;
    public static final int MAX_REDIRECTS = 5;
    public static final int MAX_RETRIES = 2;
    public static final int MAX_RETRY_AFTER = 86400;
    public static final int MAX_SYNC_THREAD = 2;
    public static final int MAX_THREAD = 4;
    public static final String MEDIA_SCANNED = "scanned";
    public static final String MIMETYPE_APK = "application/vnd.android.package-archive";
    public static final String MIMETYPE_DRM_MESSAGE = "application/vnd.oma.drm.message";
    public static final int MIN_PROGRESS_STEP = 4096;
    public static final long MIN_PROGRESS_TIME = 1500;
    public static final int MIN_RETRY_AFTER = 30;
    public static final String NO_SYSTEM_FILES = "no_system";
    public static final String OTA_UPDATE = "otaupdate";
    public static final String RECOVERY_DIRECTORY = "recovery";
    public static final String RETRY_AFTER_X_REDIRECT_COUNT = "method";
    public static final int RETRY_FIRST_DELAY = 10;
    public static final String TAG = "DownloadManager";
    public static final String TRANSCODE_RESULT_SUB_DIR_NAME = "m3u8TransResult";
    public static final String UID = "uid";

    static {
        boolean z = DownloadRuntime.GLOBAL_DEBUG;
        LOGX = z;
        LOGV = z;
        LOCAL_LOGVV = z;
        LOGVV = z;
    }
}
