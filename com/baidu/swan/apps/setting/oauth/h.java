package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState bTO = TaskState.INIT;
    OAuthException bTP;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bTO && this.bTP == null;
    }

    public void aew() {
        this.bTO = TaskState.FINISHED;
        this.bTP = null;
    }

    public int getErrorCode() {
        if (this.bTP == null) {
            return 0;
        }
        return this.bTP.mErrorCode;
    }

    public OAuthException aex() {
        return this.bTP;
    }

    public void a(OAuthException oAuthException) {
        this.bTP = oAuthException;
    }
}
