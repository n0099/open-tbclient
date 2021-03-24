package com.baidu.fsg.base.a;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f5124a;

    /* renamed from: b  reason: collision with root package name */
    public long f5125b;

    /* renamed from: c  reason: collision with root package name */
    public long f5126c;

    /* renamed from: d  reason: collision with root package name */
    public long f5127d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f5128e = 1;

    public c(long j) {
        this.f5124a = j;
    }

    public int a() {
        return this.f5128e;
    }

    public long b() {
        return this.f5125b;
    }

    public long c() {
        return this.f5126c;
    }

    public long d() {
        return this.f5124a;
    }

    public long e() {
        return this.f5127d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f5124a);
        sb.append(", current bytes: " + this.f5125b);
        sb.append(", total bytes: " + this.f5126c);
        sb.append(", speed: " + this.f5127d);
        sb.append(", state: " + this.f5128e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    public void a(int i) {
        this.f5128e = i;
    }

    public void b(long j) {
        this.f5126c = j;
    }

    public void c(long j) {
        this.f5127d = j;
    }

    public void a(long j) {
        this.f5125b = j;
    }
}
