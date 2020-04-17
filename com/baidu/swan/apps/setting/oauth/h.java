package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState csO = TaskState.INIT;
    OAuthException csP;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.csO && this.csP == null;
    }

    public void amE() {
        this.csO = TaskState.FINISHED;
        this.csP = null;
    }

    public int getErrorCode() {
        if (this.csP == null) {
            return 0;
        }
        return this.csP.mErrorCode;
    }

    public OAuthException amF() {
        return this.csP;
    }

    public void a(OAuthException oAuthException) {
        this.csP = oAuthException;
    }
}
