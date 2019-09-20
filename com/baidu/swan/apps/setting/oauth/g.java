package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState aVr = TaskState.INIT;
    OAuthException aVs;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.aVr && this.aVs == null;
    }

    public int getErrorCode() {
        if (this.aVs == null) {
            return 0;
        }
        return this.aVs.mErrorCode;
    }

    public OAuthException NB() {
        return this.aVs;
    }
}
