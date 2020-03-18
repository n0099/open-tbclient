package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState bTZ = TaskState.INIT;
    OAuthException bUa;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bTZ && this.bUa == null;
    }

    public void aez() {
        this.bTZ = TaskState.FINISHED;
        this.bUa = null;
    }

    public int getErrorCode() {
        if (this.bUa == null) {
            return 0;
        }
        return this.bUa.mErrorCode;
    }

    public OAuthException aeA() {
        return this.bUa;
    }

    public void a(OAuthException oAuthException) {
        this.bUa = oAuthException;
    }
}
