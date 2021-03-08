package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes8.dex */
public class h<ResultDataT> {
    TaskState dLk = TaskState.INIT;
    OAuthException dLl;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dLk && this.dLl == null;
    }

    public void aKV() {
        this.dLk = TaskState.FINISHED;
        this.dLl = null;
    }

    public int getErrorCode() {
        if (this.dLl == null) {
            return 0;
        }
        return this.dLl.mErrorCode;
    }

    public OAuthException aKW() {
        return this.dLl;
    }

    public void a(OAuthException oAuthException) {
        this.dLl = oAuthException;
    }
}
