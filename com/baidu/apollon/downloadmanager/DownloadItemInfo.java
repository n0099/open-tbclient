package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class DownloadItemInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f3672a;

    /* renamed from: b  reason: collision with root package name */
    public long f3673b;

    /* renamed from: c  reason: collision with root package name */
    public long f3674c;

    /* renamed from: d  reason: collision with root package name */
    public long f3675d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f3676e = 1;

    public DownloadItemInfo(long j) {
        this.f3672a = j;
    }

    public long getCurrentBytes() {
        return this.f3673b;
    }

    public long getDownloadId() {
        return this.f3672a;
    }

    public int getDownloadState() {
        return this.f3676e;
    }

    public long getSpeed() {
        return this.f3675d;
    }

    public long getTotalBytes() {
        return this.f3674c;
    }

    public void setCurrentBytes(long j) {
        this.f3673b = j;
    }

    public void setDownloadState(int i2) {
        this.f3676e = i2;
    }

    public void setSpeed(long j) {
        this.f3675d = j;
    }

    public void setTotalBytes(long j) {
        this.f3674c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f3672a);
        sb.append(", current bytes: " + this.f3673b);
        sb.append(", total bytes: " + this.f3674c);
        sb.append(", speed: " + this.f3675d);
        sb.append(", state: " + this.f3676e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
