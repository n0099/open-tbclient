package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState aRq = TaskState.INIT;
    OAuthException aRr;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.aRq && this.aRr == null;
    }

    public int getErrorCode() {
        if (this.aRr == null) {
            return 0;
        }
        return this.aRr.mErrorCode;
    }

    public OAuthException Kk() {
        return this.aRr;
    }
}
