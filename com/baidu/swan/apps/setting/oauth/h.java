package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState bTN = TaskState.INIT;
    OAuthException bTO;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bTN && this.bTO == null;
    }

    public void aew() {
        this.bTN = TaskState.FINISHED;
        this.bTO = null;
    }

    public int getErrorCode() {
        if (this.bTO == null) {
            return 0;
        }
        return this.bTO.mErrorCode;
    }

    public OAuthException aex() {
        return this.bTO;
    }

    public void a(OAuthException oAuthException) {
        this.bTO = oAuthException;
    }
}
