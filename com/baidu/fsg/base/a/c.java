package com.baidu.fsg.base.a;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f5290a;

    /* renamed from: b  reason: collision with root package name */
    public long f5291b;

    /* renamed from: c  reason: collision with root package name */
    public long f5292c;

    /* renamed from: d  reason: collision with root package name */
    public long f5293d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f5294e = 1;

    public c(long j) {
        this.f5290a = j;
    }

    public int a() {
        return this.f5294e;
    }

    public long b() {
        return this.f5291b;
    }

    public long c() {
        return this.f5292c;
    }

    public long d() {
        return this.f5290a;
    }

    public long e() {
        return this.f5293d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f5290a);
        sb.append(", current bytes: " + this.f5291b);
        sb.append(", total bytes: " + this.f5292c);
        sb.append(", speed: " + this.f5293d);
        sb.append(", state: " + this.f5294e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    public void a(int i2) {
        this.f5294e = i2;
    }

    public void b(long j) {
        this.f5292c = j;
    }

    public void c(long j) {
        this.f5293d = j;
    }

    public void a(long j) {
        this.f5291b = j;
    }
}
