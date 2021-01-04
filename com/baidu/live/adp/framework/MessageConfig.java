package com.baidu.live.adp.framework;

import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes11.dex */
public interface MessageConfig {
    public static final int BASE_CMD_START = 1000;
    public static final int BASE_COMMON_ERROR = -1000;
    public static final int BASE_CUSTOM_CMD = 2001000;
    public static final int BASE_CUSTOM_ERROR = -3001000;
    public static final int BASE_ERROR_START = -1000;
    public static final int BASE_HTTP_CMD = 1001000;
    public static final int BASE_HTTP_ERROR = -1001000;
    public static final int BASE_SEGMENT_LENGTH = 1000000;
    public static final int BASE_SOCKET_CMD = 1000;
    public static final int BASE_SOCKET_ERROR = -2001000;
    public static final int CMD_NETWORK_CHANGED = 2000994;
    public static final int DATABASE_CREATED = 2000998;
    public static final int DEBUGTOOL_START = 2000996;
    public static final int ERROR_MSG_DECODE_FAIL = -1003;
    public static final int ERROR_NO_RESPONSE_MSG = -1004;
    public static final int ERROR_RESPONSED_MESSAGE_CREATE = -1002;
    public static final int ERROR_TASK_CANCELED = -1000;
    public static final int ERROR_TASK_OUTTIME = -1001;
    public static final int GITT_NO_DATA = -1100;
    public static final int HTTP_CONNECT_TIME_OUT_MS_2G = 18000;
    public static final int HTTP_CONNECT_TIME_OUT_MS_3G = 10000;
    public static final int HTTP_CONNECT_TIME_OUT_MS_WIFI = 5000;
    public static final int HTTP_RETRY_COUNT = 5;
    public static final int HTTP_TIME_OUT_MS_2G = 28000;
    public static final int HTTP_TIME_OUT_MS_3G = 18000;
    public static final int HTTP_TIME_OUT_MS_WIFI = 10000;
    public static final int IMAGE_RESOURCE_RECYCLE = 2000989;
    public static final int NET_AUTO_SOCKET_FAIL = 2000999;
    public static final int PLUGIN_ALL_INSTALL = 2000988;
    public static final int PLUGIN_INSTALL_FAIL = 2000991;
    public static final int PLUGIN_INSTALL_START = 2000993;
    public static final int PLUGIN_INSTALL_SUCCESS = 2000992;
    public static final int PLUGIN_LOADED = 2000997;
    public static final int PLUGIN_LOAD_FAIL = 2000990;
    public static final int PLUGIN_MIS_UPDATE = 2000987;
    public static final int SOCKET_MAX_RETYR_CONNECT = 3;
    public static final int SOCKET_MIN_TIME_OUT = 3000;
    public static final int SOCKET_RECEIVE_MSG = 2000986;
    public static final int SOCKET_RETRY_COUNT = 3;
    public static final int SOCKET_TIME_OUT_MS_2G = 20000;
    public static final int SOCKET_TIME_OUT_MS_3G = 10000;
    public static final int SOCKET_TIME_OUT_MS_WIFI = 5000;
    public static final int[] reconStrategy = {30, 60, 300, 600, 1800, SdkConfigData.DEFAULT_REQUEST_INTERVAL, 7200, 14400};
}
