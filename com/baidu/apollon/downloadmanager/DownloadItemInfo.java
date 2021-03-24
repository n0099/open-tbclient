package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes2.dex */
public class DownloadItemInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f3589a;

    /* renamed from: b  reason: collision with root package name */
    public long f3590b;

    /* renamed from: c  reason: collision with root package name */
    public long f3591c;

    /* renamed from: d  reason: collision with root package name */
    public long f3592d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f3593e = 1;

    public DownloadItemInfo(long j) {
        this.f3589a = j;
    }

    public long getCurrentBytes() {
        return this.f3590b;
    }

    public long getDownloadId() {
        return this.f3589a;
    }

    public int getDownloadState() {
        return this.f3593e;
    }

    public long getSpeed() {
        return this.f3592d;
    }

    public long getTotalBytes() {
        return this.f3591c;
    }

    public void setCurrentBytes(long j) {
        this.f3590b = j;
    }

    public void setDownloadState(int i) {
        this.f3593e = i;
    }

    public void setSpeed(long j) {
        this.f3592d = j;
    }

    public void setTotalBytes(long j) {
        this.f3591c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f3589a);
        sb.append(", current bytes: " + this.f3590b);
        sb.append(", total bytes: " + this.f3591c);
        sb.append(", speed: " + this.f3592d);
        sb.append(", state: " + this.f3593e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
