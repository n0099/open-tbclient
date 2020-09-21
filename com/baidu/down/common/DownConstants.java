package com.baidu.down.common;
/* loaded from: classes14.dex */
public interface DownConstants {
    public static final int DF_BUFFER_SIZE = 16384;
    public static final int DF_MAX_BYTEARRAY_SIZE = 100;
    public static final long[] DF_RETRY_INTERVALS = {0, 2000, 8000, 64000, 512000};
    public static final int DOWNLOAD_COMMON_VERSION = 7;
    public static final int MAX_DEFAULT_DOWNLOAD_COUNT = 3;
    public static final int MESSAGE_TYPE_RETRY_DETAIL = 1;
    public static final int PRIORITY_LEVEL_1 = 1;
    public static final int PRIORITY_LEVEL_2 = 2;
    public static final int PRIORITY_LEVEL_3 = 3;
    public static final int PRIORITY_LEVEL_4 = 4;
    public static final int PRIORITY_LEVEL_5 = 5;
    public static final int REQUEST_STAGE_BEGIN = 1;
    public static final int REQUEST_STAGE_RECEIVE_DATA = 4;
    public static final int REQUEST_STAGE_RETRY_COMMON = 3;
    public static final int REQUEST_STAGE_RETRY_STRATEGY = 2;
    public static final int STATUS_RECV_CANCEL = 1004;
    public static final int STATUS_RECV_CONTINUE = 1007;
    public static final int STATUS_RECV_ERROR = 1005;
    public static final int STATUS_RECV_FINISHED = 1003;
    public static final int STATUS_RECV_PAUSE = 1006;
    public static final int STATUS_RECV_PROCESS = 1002;
    public static final int STATUS_RECV_START = 1001;
    public static final int STATUS_RECV_WAIT = 1009;
    public static final int STATUS_TASK_START = 1000;
    public static final int STATUS_WRITE_FINISHED = 1008;
}
