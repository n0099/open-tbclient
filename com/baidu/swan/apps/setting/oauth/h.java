package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes9.dex */
public class h<ResultDataT> {
    TaskState dJJ = TaskState.INIT;
    OAuthException dJK;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dJJ && this.dJK == null;
    }

    public void aKS() {
        this.dJJ = TaskState.FINISHED;
        this.dJK = null;
    }

    public int getErrorCode() {
        if (this.dJK == null) {
            return 0;
        }
        return this.dJK.mErrorCode;
    }

    public OAuthException aKT() {
        return this.dJK;
    }

    public void a(OAuthException oAuthException) {
        this.dJK = oAuthException;
    }
}
