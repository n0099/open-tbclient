package com.baidu.sapi2.shell.response;
/* loaded from: classes2.dex */
public class SapiResponse {
    public int errorCode;
    public String errorMsg;

    public SapiResponse() {
        this.errorCode = -100;
        this.errorMsg = "";
    }

    public SapiResponse(int i2, String str) {
        this.errorCode = i2;
        this.errorMsg = str;
    }
}
