package com.baidu.location.c;

import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f6599a;

    /* renamed from: b  reason: collision with root package name */
    public int f6600b;

    /* renamed from: c  reason: collision with root package name */
    public int f6601c;

    /* renamed from: d  reason: collision with root package name */
    public int f6602d;

    /* renamed from: e  reason: collision with root package name */
    public int f6603e;

    /* renamed from: f  reason: collision with root package name */
    public int f6604f;

    /* renamed from: g  reason: collision with root package name */
    public long f6605g;

    /* renamed from: h  reason: collision with root package name */
    public int f6606h;

    /* renamed from: i  reason: collision with root package name */
    public char f6607i;
    public int j;
    public String k;
    public boolean l;

    public a() {
        this.f6599a = -1;
        this.f6600b = -1;
        this.f6601c = -1;
        this.f6602d = -1;
        this.f6603e = Integer.MAX_VALUE;
        this.f6604f = Integer.MAX_VALUE;
        this.f6605g = 0L;
        this.f6606h = -1;
        this.f6607i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6605g = System.currentTimeMillis();
    }

    public a(int i2, int i3, int i4, int i5, int i6, char c2, int i7) {
        this.f6599a = -1;
        this.f6600b = -1;
        this.f6601c = -1;
        this.f6602d = -1;
        this.f6603e = Integer.MAX_VALUE;
        this.f6604f = Integer.MAX_VALUE;
        this.f6605g = 0L;
        this.f6606h = -1;
        this.f6607i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6599a = i2;
        this.f6600b = i3;
        this.f6601c = i4;
        this.f6602d = i5;
        this.f6606h = i6;
        this.f6607i = c2;
        this.f6605g = System.currentTimeMillis();
        this.j = i7;
    }

    public a(a aVar) {
        this(aVar.f6599a, aVar.f6600b, aVar.f6601c, aVar.f6602d, aVar.f6606h, aVar.f6607i, aVar.j);
        this.f6605g = aVar.f6605g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6605g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public boolean a(a aVar) {
        return this.f6599a == aVar.f6599a && this.f6600b == aVar.f6600b && this.f6602d == aVar.f6602d && this.f6601c == aVar.f6601c;
    }

    public boolean b() {
        return this.f6599a > -1 && this.f6600b > 0;
    }

    public boolean c() {
        return this.f6599a == -1 && this.f6600b == -1 && this.f6602d == -1 && this.f6601c == -1;
    }

    public boolean d() {
        return this.f6599a > -1 && this.f6600b > -1 && this.f6602d == -1 && this.f6601c == -1;
    }

    public boolean e() {
        return this.f6599a > -1 && this.f6600b > -1 && this.f6602d > -1 && this.f6601c > -1;
    }

    public void f() {
        this.l = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f6607i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6601c), Integer.valueOf(this.f6602d), Integer.valueOf(this.f6599a), Integer.valueOf(this.f6600b), Integer.valueOf(this.f6606h)));
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
        stringBuffer.append(this.f6607i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6601c), Integer.valueOf(this.f6602d), Integer.valueOf(this.f6599a), Integer.valueOf(this.f6600b), Integer.valueOf(this.f6606h)));
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(this.j);
        }
        return stringBuffer.toString();
    }
}
