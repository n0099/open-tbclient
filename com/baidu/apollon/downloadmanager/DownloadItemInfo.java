package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class DownloadItemInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f3669a;

    /* renamed from: b  reason: collision with root package name */
    public long f3670b;

    /* renamed from: c  reason: collision with root package name */
    public long f3671c;

    /* renamed from: d  reason: collision with root package name */
    public long f3672d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f3673e = 1;

    public DownloadItemInfo(long j) {
        this.f3669a = j;
    }

    public long getCurrentBytes() {
        return this.f3670b;
    }

    public long getDownloadId() {
        return this.f3669a;
    }

    public int getDownloadState() {
        return this.f3673e;
    }

    public long getSpeed() {
        return this.f3672d;
    }

    public long getTotalBytes() {
        return this.f3671c;
    }

    public void setCurrentBytes(long j) {
        this.f3670b = j;
    }

    public void setDownloadState(int i2) {
        this.f3673e = i2;
    }

    public void setSpeed(long j) {
        this.f3672d = j;
    }

    public void setTotalBytes(long j) {
        this.f3671c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f3669a);
        sb.append(", current bytes: " + this.f3670b);
        sb.append(", total bytes: " + this.f3671c);
        sb.append(", speed: " + this.f3672d);
        sb.append(", state: " + this.f3673e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
