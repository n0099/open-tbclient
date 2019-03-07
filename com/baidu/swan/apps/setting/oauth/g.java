package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState aRp = TaskState.INIT;
    OAuthException aRq;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.aRp && this.aRq == null;
    }

    public int getErrorCode() {
        if (this.aRq == null) {
            return 0;
        }
        return this.aRq.mErrorCode;
    }

    public OAuthException Kk() {
        return this.aRq;
    }
}
