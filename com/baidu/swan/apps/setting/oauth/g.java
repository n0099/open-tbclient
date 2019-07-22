package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState aUT = TaskState.INIT;
    OAuthException aUU;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.aUT && this.aUU == null;
    }

    public int getErrorCode() {
        if (this.aUU == null) {
            return 0;
        }
        return this.aUU.mErrorCode;
    }

    public OAuthException Nx() {
        return this.aUU;
    }
}
