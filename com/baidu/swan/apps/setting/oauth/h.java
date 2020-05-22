package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState cEQ = TaskState.INIT;
    OAuthException cER;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.cEQ && this.cER == null;
    }

    public void aqG() {
        this.cEQ = TaskState.FINISHED;
        this.cER = null;
    }

    public int getErrorCode() {
        if (this.cER == null) {
            return 0;
        }
        return this.cER.mErrorCode;
    }

    public OAuthException aqH() {
        return this.cER;
    }

    public void a(OAuthException oAuthException) {
        this.cER = oAuthException;
    }
}
