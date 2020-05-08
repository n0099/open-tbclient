package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes11.dex */
public class h<ResultDataT> {
    TaskState csU = TaskState.INIT;
    OAuthException csV;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.csU && this.csV == null;
    }

    public void amD() {
        this.csU = TaskState.FINISHED;
        this.csV = null;
    }

    public int getErrorCode() {
        if (this.csV == null) {
            return 0;
        }
        return this.csV.mErrorCode;
    }

    public OAuthException amE() {
        return this.csV;
    }

    public void a(OAuthException oAuthException) {
        this.csV = oAuthException;
    }
}
