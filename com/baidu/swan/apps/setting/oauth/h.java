package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes7.dex */
public class h<ResultDataT> {
    TaskState cMR = TaskState.INIT;
    OAuthException cMS;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.cMR && this.cMS == null;
    }

    public void atH() {
        this.cMR = TaskState.FINISHED;
        this.cMS = null;
    }

    public int getErrorCode() {
        if (this.cMS == null) {
            return 0;
        }
        return this.cMS.mErrorCode;
    }

    public OAuthException atI() {
        return this.cMS;
    }

    public void a(OAuthException oAuthException) {
        this.cMS = oAuthException;
    }
}
