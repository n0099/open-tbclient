package com.baidu.fsg.base.a;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f5125a;

    /* renamed from: b  reason: collision with root package name */
    public long f5126b;

    /* renamed from: c  reason: collision with root package name */
    public long f5127c;

    /* renamed from: d  reason: collision with root package name */
    public long f5128d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f5129e = 1;

    public c(long j) {
        this.f5125a = j;
    }

    public int a() {
        return this.f5129e;
    }

    public long b() {
        return this.f5126b;
    }

    public long c() {
        return this.f5127c;
    }

    public long d() {
        return this.f5125a;
    }

    public long e() {
        return this.f5128d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f5125a);
        sb.append(", current bytes: " + this.f5126b);
        sb.append(", total bytes: " + this.f5127c);
        sb.append(", speed: " + this.f5128d);
        sb.append(", state: " + this.f5129e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    public void a(int i) {
        this.f5129e = i;
    }

    public void b(long j) {
        this.f5127c = j;
    }

    public void c(long j) {
        this.f5128d = j;
    }

    public void a(long j) {
        this.f5126b = j;
    }
}
