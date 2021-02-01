package com.baidu.sapi2.shell.response;
/* loaded from: classes15.dex */
public class SapiResponse {
    public int errorCode;
    public String errorMsg;

    public SapiResponse() {
        this.errorCode = -100;
        this.errorMsg = "";
    }

    public SapiResponse(int i, String str) {
        this.errorCode = i;
        this.errorMsg = str;
    }
}
