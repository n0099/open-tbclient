package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState bov = TaskState.INIT;
    OAuthException bow;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bov && this.bow == null;
    }

    public int getErrorCode() {
        if (this.bow == null) {
            return 0;
        }
        return this.bow.mErrorCode;
    }

    public OAuthException Sr() {
        return this.bow;
    }
}
