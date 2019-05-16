package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState aUj = TaskState.INIT;
    OAuthException aUk;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.aUj && this.aUk == null;
    }

    public int getErrorCode() {
        if (this.aUk == null) {
            return 0;
        }
        return this.aUk.mErrorCode;
    }

    public OAuthException MI() {
        return this.aUk;
    }
}
