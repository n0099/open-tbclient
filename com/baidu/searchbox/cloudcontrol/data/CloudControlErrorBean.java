package com.baidu.searchbox.cloudcontrol.data;
/* loaded from: classes8.dex */
public class CloudControlErrorBean {
    public static final int NET_WORK_ERROR = 1;
    public static final int NO_ERROR = 0;
    public static final int PARSE_ERROR = 3;
    public static final int SERVER_ERROR = 2;
    public static final int SUB_PARSE_DATA_FORMAT_ERROR = 30;
    public static final int SUB_PARSE_DATA_NO_NODE = 31;
    private int errorCode;
    private int subErrorCode;

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public void setSubErrorCode(int i) {
        this.subErrorCode = i;
    }
}
