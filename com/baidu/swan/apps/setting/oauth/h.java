package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes7.dex */
public class h<ResultDataT> {
    TaskState dwO = TaskState.INIT;
    OAuthException dwP;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dwO && this.dwP == null;
    }

    public void aIU() {
        this.dwO = TaskState.FINISHED;
        this.dwP = null;
    }

    public int getErrorCode() {
        if (this.dwP == null) {
            return 0;
        }
        return this.dwP.mErrorCode;
    }

    public OAuthException aIV() {
        return this.dwP;
    }

    public void a(OAuthException oAuthException) {
        this.dwP = oAuthException;
    }
}
