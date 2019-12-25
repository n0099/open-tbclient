package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes9.dex */
public class h<ResultDataT> {
    TaskState bOX = TaskState.INIT;
    OAuthException bOY;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bOX && this.bOY == null;
    }

    public void abJ() {
        this.bOX = TaskState.FINISHED;
        this.bOY = null;
    }

    public int getErrorCode() {
        if (this.bOY == null) {
            return 0;
        }
        return this.bOY.mErrorCode;
    }

    public OAuthException abK() {
        return this.bOY;
    }

    public void a(OAuthException oAuthException) {
        this.bOY = oAuthException;
    }
}
