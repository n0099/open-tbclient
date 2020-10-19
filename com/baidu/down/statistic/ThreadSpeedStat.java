package com.baidu.down.statistic;
/* loaded from: classes9.dex */
public class ThreadSpeedStat {
    public static final String CLIENT_REQUEST_ID_HEADER_NAME = "cqid";
    public static final String DOWN_RESULT_STATE_CANCEL = "c";
    public static final String DOWN_RESULT_STATE_FAIL = "f";
    public static final String DOWN_RESULT_STATE_SUCCESS = "s";
    public String cqid;
    public long dTempDownSize;
    public long dend;
    public long downEndConnectTime;
    public long downEndTime;
    public long downStartConnectTime;
    public long downStartTime;
    public int drnum;
    public long dsize;
    public long dspt;
    public long dt;
    public long endWirteTime;
    public String ip;
    public long startWriteTime;
    public String url;
    public String drs = "";
    public long dstart = -1;
}
