package com.baidu.searchbox.retrieve.timer.bean;
/* loaded from: classes2.dex */
public class FetchTimerCancelBean extends FetchTimerBasicBean {
    public String mCancelJobId;

    public FetchTimerCancelBean(String str, String str2, String str3, long j, String str4) {
        super(str, str2, str3, j);
        this.mCancelJobId = str4;
    }

    public String getCancelJobId() {
        return this.mCancelJobId;
    }

    public void setCancelJobId(String str) {
        this.mCancelJobId = str;
    }

    @Override // com.baidu.searchbox.retrieve.timer.bean.FetchTimerBasicBean
    public String toString() {
        return "FetchTimerCancelBean{mJobId='" + getJobId() + "', mType='" + getType() + "', mVersion='" + getVersion() + "', mExpiredTime=" + getExpiredTime() + ", mCancelJobId='" + this.mCancelJobId + "'}";
    }
}
