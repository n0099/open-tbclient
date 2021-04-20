package com.baidu.fsg.base.a;

import android.annotation.SuppressLint;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f5160a;

    /* renamed from: b  reason: collision with root package name */
    public long f5161b;

    /* renamed from: c  reason: collision with root package name */
    public long f5162c;

    /* renamed from: d  reason: collision with root package name */
    public long f5163d;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public int f5164e = 1;

    public c(long j) {
        this.f5160a = j;
    }

    public int a() {
        return this.f5164e;
    }

    public long b() {
        return this.f5161b;
    }

    public long c() {
        return this.f5162c;
    }

    public long d() {
        return this.f5160a;
    }

    public long e() {
        return this.f5163d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f5160a);
        sb.append(", current bytes: " + this.f5161b);
        sb.append(", total bytes: " + this.f5162c);
        sb.append(", speed: " + this.f5163d);
        sb.append(", state: " + this.f5164e);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    public void a(int i) {
        this.f5164e = i;
    }

    public void b(long j) {
        this.f5162c = j;
    }

    public void c(long j) {
        this.f5163d = j;
    }

    public void a(long j) {
        this.f5161b = j;
    }
}
