package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class DownloadItemInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f3668a;

    /* renamed from: b  reason: collision with root package name */
    public long f3669b;

    /* renamed from: c  reason: collision with root package name */
    public long f3670c;

    /* renamed from: d  reason: collision with root package name */
    public long f3671d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f3672e = 1;

    public DownloadItemInfo(long j) {
        this.f3668a = j;
    }

    public long getCurrentBytes() {
        return this.f3669b;
    }

    public long getDownloadId() {
        return this.f3668a;
    }

    public int getDownloadState() {
        return this.f3672e;
    }

    public long getSpeed() {
        return this.f3671d;
    }

    public long getTotalBytes() {
        return this.f3670c;
    }

    public void setCurrentBytes(long j) {
        this.f3669b = j;
    }

    public void setDownloadState(int i2) {
        this.f3672e = i2;
    }

    public void setSpeed(long j) {
        this.f3671d = j;
    }

    public void setTotalBytes(long j) {
        this.f3670c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f3668a);
        sb.append(", current bytes: " + this.f3669b);
        sb.append(", total bytes: " + this.f3670c);
        sb.append(", speed: " + this.f3671d);
        sb.append(", state: " + this.f3672e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
