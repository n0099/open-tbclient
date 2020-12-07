package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes25.dex */
public class h<ResultDataT> {
    TaskState dDN = TaskState.INIT;
    OAuthException dDO;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dDN && this.dDO == null;
    }

    public void aMc() {
        this.dDN = TaskState.FINISHED;
        this.dDO = null;
    }

    public int getErrorCode() {
        if (this.dDO == null) {
            return 0;
        }
        return this.dDO.mErrorCode;
    }

    public OAuthException aMd() {
        return this.dDO;
    }

    public void a(OAuthException oAuthException) {
        this.dDO = oAuthException;
    }
}
