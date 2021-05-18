package com.baidu.location.c;

import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f6699a;

    /* renamed from: b  reason: collision with root package name */
    public int f6700b;

    /* renamed from: c  reason: collision with root package name */
    public int f6701c;

    /* renamed from: d  reason: collision with root package name */
    public int f6702d;

    /* renamed from: e  reason: collision with root package name */
    public int f6703e;

    /* renamed from: f  reason: collision with root package name */
    public int f6704f;

    /* renamed from: g  reason: collision with root package name */
    public long f6705g;

    /* renamed from: h  reason: collision with root package name */
    public int f6706h;

    /* renamed from: i  reason: collision with root package name */
    public char f6707i;
    public int j;
    public String k;
    public boolean l;

    public a() {
        this.f6699a = -1;
        this.f6700b = -1;
        this.f6701c = -1;
        this.f6702d = -1;
        this.f6703e = Integer.MAX_VALUE;
        this.f6704f = Integer.MAX_VALUE;
        this.f6705g = 0L;
        this.f6706h = -1;
        this.f6707i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6705g = System.currentTimeMillis();
    }

    public a(int i2, int i3, int i4, int i5, int i6, char c2, int i7) {
        this.f6699a = -1;
        this.f6700b = -1;
        this.f6701c = -1;
        this.f6702d = -1;
        this.f6703e = Integer.MAX_VALUE;
        this.f6704f = Integer.MAX_VALUE;
        this.f6705g = 0L;
        this.f6706h = -1;
        this.f6707i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6699a = i2;
        this.f6700b = i3;
        this.f6701c = i4;
        this.f6702d = i5;
        this.f6706h = i6;
        this.f6707i = c2;
        this.f6705g = System.currentTimeMillis();
        this.j = i7;
    }

    public a(a aVar) {
        this(aVar.f6699a, aVar.f6700b, aVar.f6701c, aVar.f6702d, aVar.f6706h, aVar.f6707i, aVar.j);
        this.f6705g = aVar.f6705g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6705g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public boolean a(a aVar) {
        return this.f6699a == aVar.f6699a && this.f6700b == aVar.f6700b && this.f6702d == aVar.f6702d && this.f6701c == aVar.f6701c;
    }

    public boolean b() {
        return this.f6699a > -1 && this.f6700b > 0;
    }

    public boolean c() {
        return this.f6699a == -1 && this.f6700b == -1 && this.f6702d == -1 && this.f6701c == -1;
    }

    public boolean d() {
        return this.f6699a > -1 && this.f6700b > -1 && this.f6702d == -1 && this.f6701c == -1;
    }

    public boolean e() {
        return this.f6699a > -1 && this.f6700b > -1 && this.f6702d > -1 && this.f6701c > -1;
    }

    public void f() {
        this.l = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f6707i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6701c), Integer.valueOf(this.f6702d), Integer.valueOf(this.f6699a), Integer.valueOf(this.f6700b), Integer.valueOf(this.f6706h)));
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(this.j);
        }
        if (this.l) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.f6707i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6701c), Integer.valueOf(this.f6702d), Integer.valueOf(this.f6699a), Integer.valueOf(this.f6700b), Integer.valueOf(this.f6706h)));
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(this.j);
        }
        return stringBuffer.toString();
    }
}
