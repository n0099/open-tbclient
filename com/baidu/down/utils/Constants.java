package com.baidu.down.utils;
/* loaded from: classes6.dex */
public final class Constants {
    public static final String CONFIG_URL = "http://flow.app.baidu.com/flow/api/flowset?";
    public static final boolean DEBUG = false;
    public static final int DEFAULT_WAP_CONNECT_TIMEOUT = 60000;
    public static final int DEFAULT_WAP_SOCKET_TIMEOUT = 60000;
    public static final String DOMAIN = "domain";
    public static final String DOMAIN_VALUE = "gdown.baidu.com";
    public static final long DOWNLOAD_SPEED_DATA_SIZE = 512;
    public static final long DOWNLOAD_SPEED_OFFSET_MAX = 10;
    public static final long DOWNLOAD_SPEED_THRESHOLD_OFFSET = 20;
    public static final long DOWNLOAD_TEST_SPEED_DURATION = 15;
    public static final int FILEPATH_MAX_LENGTH = 255;
    public static final String FROM = "from";
    public static final String FROM_VALUE = "as";
    public static final int HTTP_DNS_INAVAILABLE_TIME = 600;
    public static final String HTTP_HEADER_HOST = "Host";
    public static final boolean LOG_UPLOAD_DEBUG = true;
    public static final String MIMETYPE_APK = "application/vnd.android.package-archive";
    public static final String PREF_DOWNLOAD_INFO_HOST_DEFAULT = "https://appc.baidu.com/appsrv?action=downflow&native_api=1";
    public static final String PREF_LOG_HOST_DEFAULT = "http://flow.app.baidu.com/flow/api/flowlog?";
    public static final long REQUEST_CDN_IP_TIMEOUT = 5;
    public static final long REQUEST_DOWN_INFO_TIMEOUT = 15;
    public static final String SDK_VER = "3.1";
    public static final String SDK_VER_NAME = "sdk_ver";
    public static final String SPEED_STAT_URL_DEFAULT = "http://appc.baidu.com/globalflow/v1/baseflow?action=statistics";
    public static final long TEST_SPEED_THRESHOLD_DEFAULT = 10240;

    private Constants() {
    }
}
