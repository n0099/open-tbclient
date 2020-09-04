package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes8.dex */
public class h<ResultDataT> {
    TaskState cVR = TaskState.INIT;
    OAuthException cVS;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.cVR && this.cVS == null;
    }

    public void aBP() {
        this.cVR = TaskState.FINISHED;
        this.cVS = null;
    }

    public int getErrorCode() {
        if (this.cVS == null) {
            return 0;
        }
        return this.cVS.mErrorCode;
    }

    public OAuthException aBQ() {
        return this.cVS;
    }

    public void a(OAuthException oAuthException) {
        this.cVS = oAuthException;
    }
}
