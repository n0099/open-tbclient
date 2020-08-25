package com.baidu.swan.apps.setting.oauth;
/* loaded from: classes8.dex */
public class h<ResultDataT> {
    TaskState cVN = TaskState.INIT;
    OAuthException cVO;
    public ResultDataT mData;

    public boolean isOk() {
        return TaskState.FINISHED == this.cVN && this.cVO == null;
    }

    public void aBP() {
        this.cVN = TaskState.FINISHED;
        this.cVO = null;
    }

    public int getErrorCode() {
        if (this.cVO == null) {
            return 0;
        }
        return this.cVO.mErrorCode;
    }

    public OAuthException aBQ() {
        return this.cVO;
    }

    public void a(OAuthException oAuthException) {
        this.cVO = oAuthException;
    }
}
