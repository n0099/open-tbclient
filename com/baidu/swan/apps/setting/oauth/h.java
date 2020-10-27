package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes10.dex */
public class h<ResultDataT> {
    TaskState dsC = TaskState.INIT;
    OAuthException dsD;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dsC && this.dsD == null;
    }

    public void aHc() {
        this.dsC = TaskState.FINISHED;
        this.dsD = null;
    }

    public int getErrorCode() {
        if (this.dsD == null) {
            return 0;
        }
        return this.dsD.mErrorCode;
    }

    public OAuthException aHd() {
        return this.dsD;
    }

    public void a(OAuthException oAuthException) {
        this.dsD = oAuthException;
    }
}
