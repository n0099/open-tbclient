package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes10.dex */
public class h<ResultDataT> {
    TaskState dkb = TaskState.INIT;
    OAuthException dkc;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dkb && this.dkc == null;
    }

    public void aFi() {
        this.dkb = TaskState.FINISHED;
        this.dkc = null;
    }

    public int getErrorCode() {
        if (this.dkc == null) {
            return 0;
        }
        return this.dkc.mErrorCode;
    }

    public OAuthException aFj() {
        return this.dkc;
    }

    public void a(OAuthException oAuthException) {
        this.dkc = oAuthException;
    }
}
