package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState bTM = TaskState.INIT;
    OAuthException bTN;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bTM && this.bTN == null;
    }

    public void aeu() {
        this.bTM = TaskState.FINISHED;
        this.bTN = null;
    }

    public int getErrorCode() {
        if (this.bTN == null) {
            return 0;
        }
        return this.bTN.mErrorCode;
    }

    public OAuthException aev() {
        return this.bTN;
    }

    public void a(OAuthException oAuthException) {
        this.bTN = oAuthException;
    }
}
