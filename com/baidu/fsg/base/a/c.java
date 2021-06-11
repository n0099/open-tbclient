package com.baidu.fsg.base.a;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f5087a;

    /* renamed from: b  reason: collision with root package name */
    public long f5088b;

    /* renamed from: c  reason: collision with root package name */
    public long f5089c;

    /* renamed from: d  reason: collision with root package name */
    public long f5090d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f5091e = 1;

    public c(long j) {
        this.f5087a = j;
    }

    public int a() {
        return this.f5091e;
    }

    public long b() {
        return this.f5088b;
    }

    public long c() {
        return this.f5089c;
    }

    public long d() {
        return this.f5087a;
    }

    public long e() {
        return this.f5090d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f5087a);
        sb.append(", current bytes: " + this.f5088b);
        sb.append(", total bytes: " + this.f5089c);
        sb.append(", speed: " + this.f5090d);
        sb.append(", state: " + this.f5091e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    public void a(int i2) {
        this.f5091e = i2;
    }

    public void b(long j) {
        this.f5089c = j;
    }

    public void c(long j) {
        this.f5090d = j;
    }

    public void a(long j) {
        this.f5088b = j;
    }
}
