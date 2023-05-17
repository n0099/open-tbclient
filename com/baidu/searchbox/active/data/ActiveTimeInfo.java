package com.baidu.searchbox.active.data;
/* loaded from: classes3.dex */
public class ActiveTimeInfo {
    public long mClientCreatedTime;
    public long mRequestTime;
    public long mServerCreatedTime;

    public ActiveTimeInfo(long j, long j2, long j3) {
        this.mRequestTime = j;
        this.mServerCreatedTime = j2;
        this.mClientCreatedTime = j3;
    }

    public long getClientCreatedTime() {
        return this.mClientCreatedTime;
    }

    public long getRequestTime() {
        return this.mRequestTime;
    }

    public long getServerCreatedTime() {
        return this.mServerCreatedTime;
    }

    public String toString() {
        return "ActiveTimeInfo{mRequestTime=" + this.mRequestTime + ", mServerCreatedTime=" + this.mServerCreatedTime + ", mClientCreatedTime=" + this.mClientCreatedTime + '}';
    }
}
