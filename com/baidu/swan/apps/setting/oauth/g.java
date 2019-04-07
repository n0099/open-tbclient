package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState aRt = TaskState.INIT;
    OAuthException aRu;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.aRt && this.aRu == null;
    }

    public int getErrorCode() {
        if (this.aRu == null) {
            return 0;
        }
        return this.aRu.mErrorCode;
    }

    public OAuthException Ki() {
        return this.aRu;
    }
}
