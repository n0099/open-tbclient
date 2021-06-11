package com.baidu.location.c;

import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f6642a;

    /* renamed from: b  reason: collision with root package name */
    public int f6643b;

    /* renamed from: c  reason: collision with root package name */
    public int f6644c;

    /* renamed from: d  reason: collision with root package name */
    public int f6645d;

    /* renamed from: e  reason: collision with root package name */
    public int f6646e;

    /* renamed from: f  reason: collision with root package name */
    public int f6647f;

    /* renamed from: g  reason: collision with root package name */
    public long f6648g;

    /* renamed from: h  reason: collision with root package name */
    public int f6649h;

    /* renamed from: i  reason: collision with root package name */
    public char f6650i;
    public int j;
    public String k;
    public boolean l;

    public a() {
        this.f6642a = -1;
        this.f6643b = -1;
        this.f6644c = -1;
        this.f6645d = -1;
        this.f6646e = Integer.MAX_VALUE;
        this.f6647f = Integer.MAX_VALUE;
        this.f6648g = 0L;
        this.f6649h = -1;
        this.f6650i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6648g = System.currentTimeMillis();
    }

    public a(int i2, int i3, int i4, int i5, int i6, char c2, int i7) {
        this.f6642a = -1;
        this.f6643b = -1;
        this.f6644c = -1;
        this.f6645d = -1;
        this.f6646e = Integer.MAX_VALUE;
        this.f6647f = Integer.MAX_VALUE;
        this.f6648g = 0L;
        this.f6649h = -1;
        this.f6650i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = null;
        this.l = false;
        this.f6642a = i2;
        this.f6643b = i3;
        this.f6644c = i4;
        this.f6645d = i5;
        this.f6649h = i6;
        this.f6650i = c2;
        this.f6648g = System.currentTimeMillis();
        this.j = i7;
    }

    public a(a aVar) {
        this(aVar.f6642a, aVar.f6643b, aVar.f6644c, aVar.f6645d, aVar.f6649h, aVar.f6650i, aVar.j);
        this.f6648g = aVar.f6648g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6648g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public boolean a(a aVar) {
        return this.f6642a == aVar.f6642a && this.f6643b == aVar.f6643b && this.f6645d == aVar.f6645d && this.f6644c == aVar.f6644c;
    }

    public boolean b() {
        return this.f6642a > -1 && this.f6643b > 0;
    }

    public boolean c() {
        return this.f6642a == -1 && this.f6643b == -1 && this.f6645d == -1 && this.f6644c == -1;
    }

    public boolean d() {
        return this.f6642a > -1 && this.f6643b > -1 && this.f6645d == -1 && this.f6644c == -1;
    }

    public boolean e() {
        return this.f6642a > -1 && this.f6643b > -1 && this.f6645d > -1 && this.f6644c > -1;
    }

    public void f() {
        this.l = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f6650i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6644c), Integer.valueOf(this.f6645d), Integer.valueOf(this.f6642a), Integer.valueOf(this.f6643b), Integer.valueOf(this.f6649h)));
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
        stringBuffer.append(this.f6650i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6644c), Integer.valueOf(this.f6645d), Integer.valueOf(this.f6642a), Integer.valueOf(this.f6643b), Integer.valueOf(this.f6649h)));
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(this.j);
        }
        return stringBuffer.toString();
    }
}
