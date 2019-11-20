package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes2.dex */
public class g<ResultDataT> {
    TaskState bod = TaskState.INIT;
    OAuthException boe;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.bod && this.boe == null;
    }

    public int getErrorCode() {
        if (this.boe == null) {
            return 0;
        }
        return this.boe.mErrorCode;
    }

    public OAuthException St() {
        return this.boe;
    }
}
