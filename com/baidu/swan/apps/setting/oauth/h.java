package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes9.dex */
public class h<ResultDataT> {
    TaskState dMr = TaskState.INIT;
    OAuthException dMs;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dMr && this.dMs == null;
    }

    public void aOt() {
        this.dMr = TaskState.FINISHED;
        this.dMs = null;
    }

    public int getErrorCode() {
        if (this.dMs == null) {
            return 0;
        }
        return this.dMs.mErrorCode;
    }

    public OAuthException aOu() {
        return this.dMs;
    }

    public void a(OAuthException oAuthException) {
        this.dMs = oAuthException;
    }
}
