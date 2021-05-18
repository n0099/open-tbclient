package com.baidu.fsg.base.a;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f5144a;

    /* renamed from: b  reason: collision with root package name */
    public long f5145b;

    /* renamed from: c  reason: collision with root package name */
    public long f5146c;

    /* renamed from: d  reason: collision with root package name */
    public long f5147d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f5148e = 1;

    public c(long j) {
        this.f5144a = j;
    }

    public int a() {
        return this.f5148e;
    }

    public long b() {
        return this.f5145b;
    }

    public long c() {
        return this.f5146c;
    }

    public long d() {
        return this.f5144a;
    }

    public long e() {
        return this.f5147d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f5144a);
        sb.append(", current bytes: " + this.f5145b);
        sb.append(", total bytes: " + this.f5146c);
        sb.append(", speed: " + this.f5147d);
        sb.append(", state: " + this.f5148e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    public void a(int i2) {
        this.f5148e = i2;
    }

    public void b(long j) {
        this.f5146c = j;
    }

    public void c(long j) {
        this.f5147d = j;
    }

    public void a(long j) {
        this.f5145b = j;
    }
}
