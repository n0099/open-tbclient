package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState aRu = TaskState.INIT;
    OAuthException aRv;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.aRu && this.aRv == null;
    }

    public int getErrorCode() {
        if (this.aRv == null) {
            return 0;
        }
        return this.aRv.mErrorCode;
    }

    public OAuthException Ki() {
        return this.aRv;
    }
}
