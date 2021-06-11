package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class DownloadItemInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f3691a;

    /* renamed from: b  reason: collision with root package name */
    public long f3692b;

    /* renamed from: c  reason: collision with root package name */
    public long f3693c;

    /* renamed from: d  reason: collision with root package name */
    public long f3694d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f3695e = 1;

    public DownloadItemInfo(long j) {
        this.f3691a = j;
    }

    public long getCurrentBytes() {
        return this.f3692b;
    }

    public long getDownloadId() {
        return this.f3691a;
    }

    public int getDownloadState() {
        return this.f3695e;
    }

    public long getSpeed() {
        return this.f3694d;
    }

    public long getTotalBytes() {
        return this.f3693c;
    }

    public void setCurrentBytes(long j) {
        this.f3692b = j;
    }

    public void setDownloadState(int i2) {
        this.f3695e = i2;
    }

    public void setSpeed(long j) {
        this.f3694d = j;
    }

    public void setTotalBytes(long j) {
        this.f3693c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f3691a);
        sb.append(", current bytes: " + this.f3692b);
        sb.append(", total bytes: " + this.f3693c);
        sb.append(", speed: " + this.f3694d);
        sb.append(", state: " + this.f3695e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
