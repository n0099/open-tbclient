package com.baidu.searchbox.retrieve.timer.bean;
/* loaded from: classes4.dex */
public class FetchTimerBasicBean {
    public long mExpiredTime;
    public String mJobId;
    public String mType;
    public String mVersion;

    public FetchTimerBasicBean(String str, String str2, String str3, long j) {
        this.mJobId = str;
        this.mType = str2;
        this.mVersion = str3;
        this.mExpiredTime = j;
    }

    public long getExpiredTime() {
        return this.mExpiredTime;
    }

    public String getJobId() {
        return this.mJobId;
    }

    public String getType() {
        return this.mType;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setExpiredTime(long j) {
        this.mExpiredTime = j;
    }

    public void setJobId(String str) {
        this.mJobId = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "FetchTimerBasicBean{mJobId='" + this.mJobId + "', mType='" + this.mType + "', mVersion='" + this.mVersion + "', mExpiredTime=" + this.mExpiredTime + '}';
    }
}
