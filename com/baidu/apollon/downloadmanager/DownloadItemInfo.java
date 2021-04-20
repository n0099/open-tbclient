package com.baidu.apollon.downloadmanager;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class DownloadItemInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f3625a;

    /* renamed from: b  reason: collision with root package name */
    public long f3626b;

    /* renamed from: c  reason: collision with root package name */
    public long f3627c;

    /* renamed from: d  reason: collision with root package name */
    public long f3628d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f3629e = 1;

    public DownloadItemInfo(long j) {
        this.f3625a = j;
    }

    public long getCurrentBytes() {
        return this.f3626b;
    }

    public long getDownloadId() {
        return this.f3625a;
    }

    public int getDownloadState() {
        return this.f3629e;
    }

    public long getSpeed() {
        return this.f3628d;
    }

    public long getTotalBytes() {
        return this.f3627c;
    }

    public void setCurrentBytes(long j) {
        this.f3626b = j;
    }

    public void setDownloadState(int i) {
        this.f3629e = i;
    }

    public void setSpeed(long j) {
        this.f3628d = j;
    }

    public void setTotalBytes(long j) {
        this.f3627c = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f3625a);
        sb.append(", current bytes: " + this.f3626b);
        sb.append(", total bytes: " + this.f3627c);
        sb.append(", speed: " + this.f3628d);
        sb.append(", state: " + this.f3629e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
