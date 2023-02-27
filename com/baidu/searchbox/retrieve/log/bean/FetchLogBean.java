package com.baidu.searchbox.retrieve.log.bean;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FetchLogBean {
    public long mEndTime;
    public long mExpiredTime;
    public String mJobId;
    public long mMaxSizeLimit;
    public String mNetwork;
    public ArrayList<String> mSpace;
    public long mStartTime;
    public String mType;
    public String mVersion;

    public FetchLogBean(String str, String str2, String str3, long j, long j2, long j3, long j4, ArrayList<String> arrayList, String str4) {
        this.mJobId = str;
        this.mType = str2;
        this.mVersion = str3;
        this.mExpiredTime = j;
        this.mStartTime = j2;
        this.mEndTime = j3;
        this.mMaxSizeLimit = j4;
        this.mSpace = arrayList;
        this.mNetwork = str4;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public long getExpiredTime() {
        return this.mExpiredTime;
    }

    public String getJobId() {
        return this.mJobId;
    }

    public long getMaxSizeLimit() {
        return this.mMaxSizeLimit;
    }

    public String getNetwork() {
        return this.mNetwork;
    }

    public ArrayList<String> getSpace() {
        return this.mSpace;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public String getType() {
        return this.mType;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void setExpiredTime(long j) {
        this.mExpiredTime = j;
    }

    public void setJobId(String str) {
        this.mJobId = str;
    }

    public void setMaxSizeLimit(long j) {
        this.mMaxSizeLimit = j;
    }

    public void setNetwork(String str) {
        this.mNetwork = str;
    }

    public void setSpace(ArrayList<String> arrayList) {
        this.mSpace = arrayList;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "FetchLogBean{mJobId='" + this.mJobId + "', mType='" + this.mType + "', mVersion='" + this.mVersion + "', mExpiredTime=" + this.mExpiredTime + ", mStartTime=" + this.mStartTime + ", mEndTime=" + this.mEndTime + ", maxSizeLimit=" + this.mMaxSizeLimit + ", mSpace=" + this.mSpace + ", network='" + this.mNetwork + "'}";
    }
}
