package com.baidu.live.adp.framework.message;
/* loaded from: classes4.dex */
public class PerformanceData {
    public long mQueneTime = 0;
    public long mNetConTime = 0;
    public long mNetRWTime = 0;
    public long mFirstByteReachTime = 0;
    public long mAllDataReadTime = 0;
    public long mCompressTime = 0;
    public long mAnalysisTime = 0;
    public long mTaskWaitTime = 0;
    public int mSocketErrNo = 0;
    public long mSocketCostTime = 0;
    public long mHttpRetryNum = 0;
    public long mHttpRetryCostTime = 0;

    /* loaded from: classes4.dex */
    public static class SOCKET_ERR_NO {
        public static final int CMD_110004_NO = 8;
        public static final int IS_NOT_ONLIEN_OR_NO_LONG_CON_ERR_NO = 2;
        public static final int LCS_SWITCH_HTTP_NO = 9;
        public static final int LONG_CON_ERR_CNT_OVERTIMES_NO = 4;
        public static final int NET_ERR_NO = 1;
        public static final int NOT_CONTAINS_CMD_NO = 6;
        public static final int NOT_CONTAINS_URL_NO = 7;
        public static final int SEND_MSG_NO = 5;
        public static final int SYNC_SWITCH_CLOSE_NO = 3;
    }
}
