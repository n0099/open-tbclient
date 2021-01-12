package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes8.dex */
public class h<ResultDataT> {
    TaskState dHF = TaskState.INIT;
    OAuthException dHG;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dHF && this.dHG == null;
    }

    public void aKz() {
        this.dHF = TaskState.FINISHED;
        this.dHG = null;
    }

    public int getErrorCode() {
        if (this.dHG == null) {
            return 0;
        }
        return this.dHG.mErrorCode;
    }

    public OAuthException aKA() {
        return this.dHG;
    }

    public void a(OAuthException oAuthException) {
        this.dHG = oAuthException;
    }
}
