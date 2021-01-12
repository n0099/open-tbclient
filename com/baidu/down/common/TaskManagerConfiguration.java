package com.baidu.down.common;
/* loaded from: classes3.dex */
public class TaskManagerConfiguration {
    private String mDomainNameToIpReg;
    private String mHttpDnsServerIp;
    private int mLogLevel;
    private String mPreResolveDomainName;
    private String mURLRetryHostReg;
    private int maxTaskCount = 3;
    private int maxBufferCount = 100;
    private int bufferSize = 16384;
    private long[] retryIntervals = DownConstants.DF_RETRY_INTERVALS;
    private boolean retryNetDetect = true;
    private int mTrafficStatsTag = 0;
    private boolean mDomainNameToIpEnable = false;
    private boolean mHttpRetryStrategyEnable = false;
    private boolean mDownSpeedStatEnable = false;

    public String getPreResolveDominName() {
        return this.mPreResolveDomainName;
    }

    public void setPreResolveDominName(String str) {
        this.mPreResolveDomainName = str;
    }

    public String getHttpDnsServerIp() {
        return this.mHttpDnsServerIp;
    }

    public void setHttpDnsServerIp(String str) {
        this.mHttpDnsServerIp = str;
    }

    public int getMaxTaskCount() {
        return this.maxTaskCount;
    }

    public void setMaxTaskCount(int i) {
        if (i <= 0 || i > 3) {
            throw new RuntimeException("### maxTaskCount should be 0-3");
        }
        this.maxTaskCount = i;
    }

    public int getMaxBufferCount() {
        return this.maxBufferCount;
    }

    public void setMaxBufferCount(int i) {
        if (this.maxTaskCount <= 0) {
            throw new RuntimeException("### maxBufferCount should be bigger than 0!");
        }
        this.maxBufferCount = i;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(int i) {
        if (i <= 0) {
            throw new RuntimeException("### bufferSize should be bigger than 0!");
        }
        this.bufferSize = i;
    }

    public void setRetryIntervals(long[] jArr) {
        if (jArr != null) {
            this.retryIntervals = jArr;
        }
    }

    public long[] getRetryIntervals() {
        return this.retryIntervals;
    }

    public boolean isRetryNetDetect() {
        return this.retryNetDetect;
    }

    public void setRetryNetDetect(boolean z) {
        this.retryNetDetect = z;
    }

    public int getTrafficStatsTag() {
        return this.mTrafficStatsTag;
    }

    public void setTrafficStatsTag(int i) {
        this.mTrafficStatsTag = i;
    }

    public String getURLRetryHostReg() {
        return this.mURLRetryHostReg;
    }

    public void setURLRetryHostReg(String str) {
        this.mURLRetryHostReg = str;
    }

    public int getLogLevel() {
        return this.mLogLevel;
    }

    public void setLogLevel(int i) {
        this.mLogLevel = i;
    }

    public String getDomainNameToIpReg() {
        return this.mDomainNameToIpReg;
    }

    public void setDomainNameToIpReg(String str) {
        this.mDomainNameToIpReg = str;
    }

    public boolean geDomainNameToIpEnable() {
        return this.mDomainNameToIpEnable;
    }

    public void setDomainNameToIpEnable(boolean z) {
        this.mDomainNameToIpEnable = z;
    }

    public boolean getHttpRetryStrategyEnable() {
        return this.mHttpRetryStrategyEnable;
    }

    public void setHttpRetryStrategyEnable(boolean z) {
        this.mHttpRetryStrategyEnable = z;
    }

    public boolean getDownSpeedStatEnable() {
        return this.mDownSpeedStatEnable;
    }

    public void setDownSpeedStatEnable(boolean z) {
        this.mDownSpeedStatEnable = z;
    }
}
