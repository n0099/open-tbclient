package com.baidu.searchbox.retrieve.timer.bean;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FetchTimerBean extends FetchTimerBasicBean {
    public long mEndTime;
    public int mFrequency;
    public long mMaxTotalFileSize;
    public String mNetwork;
    public ArrayList<String> mSpace;
    public long mStartTime;

    public FetchTimerBean(String str, String str2, String str3, long j, long j2, long j3, long j4, ArrayList<String> arrayList, String str4, int i) {
        super(str, str2, str3, j);
        this.mStartTime = j2;
        this.mEndTime = j3;
        this.mMaxTotalFileSize = j4;
        this.mSpace = arrayList;
        this.mNetwork = str4;
        this.mFrequency = i;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public long getMaxTotalFileSize() {
        return this.mMaxTotalFileSize;
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

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void setFrequency(int i) {
        this.mFrequency = i;
    }

    public void setMaxTotalFileSize(long j) {
        this.mMaxTotalFileSize = j;
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

    @Override // com.baidu.searchbox.retrieve.timer.bean.FetchTimerBasicBean
    public String toString() {
        return "FetchTimerBean{mJobId='" + getJobId() + "', mType='" + getType() + "', mVersion='" + getVersion() + "', mExpiredTime=" + getExpiredTime() + ", mStartTime=" + this.mStartTime + ", mEndTime=" + this.mEndTime + ", mMaxTotalFileSize=" + this.mMaxTotalFileSize + ", mSpace=" + this.mSpace + ", mNetwork='" + this.mNetwork + "', mFrequency=" + this.mFrequency + '}';
    }
}
