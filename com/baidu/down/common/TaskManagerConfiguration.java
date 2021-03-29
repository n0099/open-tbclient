package com.baidu.down.common;
/* loaded from: classes.dex */
public class TaskManagerConfiguration {
    public String mDomainNameToIpReg;
    public String mHttpDnsServerIp;
    public int mLogLevel;
    public String mPreResolveDomainName;
    public String mURLRetryHostReg;
    public int maxTaskCount = 3;
    public int maxBufferCount = 100;
    public int bufferSize = 16384;
    public long[] retryIntervals = DownConstants.DF_RETRY_INTERVALS;
    public boolean retryNetDetect = true;
    public int mTrafficStatsTag = 0;
    public boolean mDomainNameToIpEnable = false;
    public boolean mHttpRetryStrategyEnable = false;
    public boolean mDownSpeedStatEnable = false;

    public boolean geDomainNameToIpEnable() {
        return this.mDomainNameToIpEnable;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public String getDomainNameToIpReg() {
        return this.mDomainNameToIpReg;
    }

    public boolean getDownSpeedStatEnable() {
        return this.mDownSpeedStatEnable;
    }

    public String getHttpDnsServerIp() {
        return this.mHttpDnsServerIp;
    }

    public boolean getHttpRetryStrategyEnable() {
        return this.mHttpRetryStrategyEnable;
    }

    public int getLogLevel() {
        return this.mLogLevel;
    }

    public int getMaxBufferCount() {
        return this.maxBufferCount;
    }

    public int getMaxTaskCount() {
        return this.maxTaskCount;
    }

    public String getPreResolveDominName() {
        return this.mPreResolveDomainName;
    }

    public long[] getRetryIntervals() {
        return this.retryIntervals;
    }

    public int getTrafficStatsTag() {
        return this.mTrafficStatsTag;
    }

    public String getURLRetryHostReg() {
        return this.mURLRetryHostReg;
    }

    public boolean isRetryNetDetect() {
        return this.retryNetDetect;
    }

    public void setBufferSize(int i) {
        if (i > 0) {
            this.bufferSize = i;
            return;
        }
        throw new RuntimeException("### bufferSize should be bigger than 0!");
    }

    public void setDomainNameToIpEnable(boolean z) {
        this.mDomainNameToIpEnable = z;
    }

    public void setDomainNameToIpReg(String str) {
        this.mDomainNameToIpReg = str;
    }

    public void setDownSpeedStatEnable(boolean z) {
        this.mDownSpeedStatEnable = z;
    }

    public void setHttpDnsServerIp(String str) {
        this.mHttpDnsServerIp = str;
    }

    public void setHttpRetryStrategyEnable(boolean z) {
        this.mHttpRetryStrategyEnable = z;
    }

    public void setLogLevel(int i) {
        this.mLogLevel = i;
    }

    public void setMaxBufferCount(int i) {
        if (this.maxTaskCount > 0) {
            this.maxBufferCount = i;
            return;
        }
        throw new RuntimeException("### maxBufferCount should be bigger than 0!");
    }

    public void setMaxTaskCount(int i) {
        if (i > 0 && i <= 3) {
            this.maxTaskCount = i;
            return;
        }
        throw new RuntimeException("### maxTaskCount should be 0-3");
    }

    public void setPreResolveDominName(String str) {
        this.mPreResolveDomainName = str;
    }

    public void setRetryIntervals(long[] jArr) {
        if (jArr != null) {
            this.retryIntervals = jArr;
        }
    }

    public void setRetryNetDetect(boolean z) {
        this.retryNetDetect = z;
    }

    public void setTrafficStatsTag(int i) {
        this.mTrafficStatsTag = i;
    }

    public void setURLRetryHostReg(String str) {
        this.mURLRetryHostReg = str;
    }
}
