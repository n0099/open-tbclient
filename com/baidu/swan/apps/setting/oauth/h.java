package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes10.dex */
public class h<ResultDataT> {
    TaskState bPH = TaskState.INIT;
    OAuthException bPI;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bPH && this.bPI == null;
    }

    public void acg() {
        this.bPH = TaskState.FINISHED;
        this.bPI = null;
    }

    public int getErrorCode() {
        if (this.bPI == null) {
            return 0;
        }
        return this.bPI.mErrorCode;
    }

    public OAuthException ach() {
        return this.bPI;
    }

    public void a(OAuthException oAuthException) {
        this.bPI = oAuthException;
    }
}
