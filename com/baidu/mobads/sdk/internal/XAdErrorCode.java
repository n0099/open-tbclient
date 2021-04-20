package com.baidu.mobads.sdk.internal;
/* loaded from: classes2.dex */
public enum XAdErrorCode {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");
    
    public static final String ERROR_CODE_MESSAGE = "msg";
    public int code;
    public String msg;

    XAdErrorCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }
}
