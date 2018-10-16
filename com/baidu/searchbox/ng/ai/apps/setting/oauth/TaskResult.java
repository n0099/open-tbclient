package com.baidu.searchbox.ng.ai.apps.setting.oauth;
/* loaded from: classes2.dex */
public class TaskResult<ResultDataT> implements OAuthErrorCode {
    public ResultDataT mData;
    OAuthException mException;
    TaskState mStatus = TaskState.INIT;

    public boolean isOk() {
        return TaskState.FINISHED == this.mStatus && this.mException == null;
    }

    public int getErrorCode() {
        if (this.mException == null) {
            return 0;
        }
        return this.mException.mErrorCode;
    }

    public OAuthException getError() {
        return this.mException;
    }
}
