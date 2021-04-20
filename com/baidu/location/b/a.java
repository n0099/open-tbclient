package com.baidu.location.b;

import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f6644a;

    /* renamed from: b  reason: collision with root package name */
    public int f6645b;

    /* renamed from: c  reason: collision with root package name */
    public int f6646c;

    /* renamed from: d  reason: collision with root package name */
    public int f6647d;

    /* renamed from: e  reason: collision with root package name */
    public int f6648e;

    /* renamed from: f  reason: collision with root package name */
    public int f6649f;

    /* renamed from: g  reason: collision with root package name */
    public long f6650g;

    /* renamed from: h  reason: collision with root package name */
    public int f6651h;
    public char i;
    public String j;
    public boolean k;

    public a() {
        this.f6644a = -1;
        this.f6645b = -1;
        this.f6646c = -1;
        this.f6647d = -1;
        this.f6648e = Integer.MAX_VALUE;
        this.f6649f = Integer.MAX_VALUE;
        this.f6650g = 0L;
        this.f6651h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.f6650g = System.currentTimeMillis();
    }

    public a(int i, int i2, int i3, int i4, int i5, char c2) {
        this.f6644a = -1;
        this.f6645b = -1;
        this.f6646c = -1;
        this.f6647d = -1;
        this.f6648e = Integer.MAX_VALUE;
        this.f6649f = Integer.MAX_VALUE;
        this.f6650g = 0L;
        this.f6651h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.f6644a = i;
        this.f6645b = i2;
        this.f6646c = i3;
        this.f6647d = i4;
        this.f6651h = i5;
        this.i = c2;
        this.f6650g = System.currentTimeMillis();
    }

    public a(a aVar) {
        this(aVar.f6644a, aVar.f6645b, aVar.f6646c, aVar.f6647d, aVar.f6651h, aVar.i);
        this.f6650g = aVar.f6650g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6650g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public boolean a(a aVar) {
        return this.f6644a == aVar.f6644a && this.f6645b == aVar.f6645b && this.f6647d == aVar.f6647d && this.f6646c == aVar.f6646c;
    }

    public boolean b() {
        return this.f6644a > -1 && this.f6645b > 0;
    }

    public boolean c() {
        return this.f6644a == -1 && this.f6645b == -1 && this.f6647d == -1 && this.f6646c == -1;
    }

    public boolean d() {
        return this.f6644a > -1 && this.f6645b > -1 && this.f6647d == -1 && this.f6646c == -1;
    }

    public boolean e() {
        return this.f6644a > -1 && this.f6645b > -1 && this.f6647d > -1 && this.f6646c > -1;
    }

    public void f() {
        this.k = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6646c), Integer.valueOf(this.f6647d), Integer.valueOf(this.f6644a), Integer.valueOf(this.f6645b), Integer.valueOf(this.f6651h)));
        if (this.k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6646c), Integer.valueOf(this.f6647d), Integer.valueOf(this.f6644a), Integer.valueOf(this.f6645b), Integer.valueOf(this.f6651h)));
        return stringBuffer.toString();
    }
}
