package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState cJA = TaskState.INIT;
    OAuthException cJB;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.cJA && this.cJB == null;
    }

    public void arM() {
        this.cJA = TaskState.FINISHED;
        this.cJB = null;
    }

    public int getErrorCode() {
        if (this.cJB == null) {
            return 0;
        }
        return this.cJB.mErrorCode;
    }

    public OAuthException arN() {
        return this.cJB;
    }

    public void a(OAuthException oAuthException) {
        this.cJB = oAuthException;
    }
}
