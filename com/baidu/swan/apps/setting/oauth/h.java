package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes3.dex */
public class h<ResultDataT> {
    TaskState cXR = TaskState.INIT;
    OAuthException cXS;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.cXR && this.cXS == null;
    }

    public void aCz() {
        this.cXR = TaskState.FINISHED;
        this.cXS = null;
    }

    public int getErrorCode() {
        if (this.cXS == null) {
            return 0;
        }
        return this.cXS.mErrorCode;
    }

    public OAuthException aCA() {
        return this.cXS;
    }

    public void a(OAuthException oAuthException) {
        this.cXS = oAuthException;
    }
}
