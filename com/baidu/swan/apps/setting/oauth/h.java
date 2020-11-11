package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes10.dex */
public class h<ResultDataT> {
    TaskState dyv = TaskState.INIT;
    OAuthException dyw;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.dyv && this.dyw == null;
    }

    public void aJC() {
        this.dyv = TaskState.FINISHED;
        this.dyw = null;
    }

    public int getErrorCode() {
        if (this.dyw == null) {
            return 0;
        }
        return this.dyw.mErrorCode;
    }

    public OAuthException aJD() {
        return this.dyw;
    }

    public void a(OAuthException oAuthException) {
        this.dyw = oAuthException;
    }
}
