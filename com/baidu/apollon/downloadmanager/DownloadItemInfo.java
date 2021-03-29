package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class DownloadItemInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f3590a;

    /* renamed from: b  reason: collision with root package name */
    public long f3591b;

    /* renamed from: c  reason: collision with root package name */
    public long f3592c;

    /* renamed from: d  reason: collision with root package name */
    public long f3593d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f3594e = 1;

    public DownloadItemInfo(long j) {
        this.f3590a = j;
    }

    public long getCurrentBytes() {
        return this.f3591b;
    }

    public long getDownloadId() {
        return this.f3590a;
    }

    public int getDownloadState() {
        return this.f3594e;
    }

    public long getSpeed() {
        return this.f3593d;
    }

    public long getTotalBytes() {
        return this.f3592c;
    }

    public void setCurrentBytes(long j) {
        this.f3591b = j;
    }

    public void setDownloadState(int i) {
        this.f3594e = i;
    }

    public void setSpeed(long j) {
        this.f3593d = j;
    }

    public void setTotalBytes(long j) {
        this.f3592c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f3590a);
        sb.append(", current bytes: " + this.f3591b);
        sb.append(", total bytes: " + this.f3592c);
        sb.append(", speed: " + this.f3593d);
        sb.append(", state: " + this.f3594e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
