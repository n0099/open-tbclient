package com.baidu.location.b;

import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f6609a;

    /* renamed from: b  reason: collision with root package name */
    public int f6610b;

    /* renamed from: c  reason: collision with root package name */
    public int f6611c;

    /* renamed from: d  reason: collision with root package name */
    public int f6612d;

    /* renamed from: e  reason: collision with root package name */
    public int f6613e;

    /* renamed from: f  reason: collision with root package name */
    public int f6614f;

    /* renamed from: g  reason: collision with root package name */
    public long f6615g;

    /* renamed from: h  reason: collision with root package name */
    public int f6616h;
    public char i;
    public String j;
    public boolean k;

    public a() {
        this.f6609a = -1;
        this.f6610b = -1;
        this.f6611c = -1;
        this.f6612d = -1;
        this.f6613e = Integer.MAX_VALUE;
        this.f6614f = Integer.MAX_VALUE;
        this.f6615g = 0L;
        this.f6616h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.f6615g = System.currentTimeMillis();
    }

    public a(int i, int i2, int i3, int i4, int i5, char c2) {
        this.f6609a = -1;
        this.f6610b = -1;
        this.f6611c = -1;
        this.f6612d = -1;
        this.f6613e = Integer.MAX_VALUE;
        this.f6614f = Integer.MAX_VALUE;
        this.f6615g = 0L;
        this.f6616h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.f6609a = i;
        this.f6610b = i2;
        this.f6611c = i3;
        this.f6612d = i4;
        this.f6616h = i5;
        this.i = c2;
        this.f6615g = System.currentTimeMillis();
    }

    public a(a aVar) {
        this(aVar.f6609a, aVar.f6610b, aVar.f6611c, aVar.f6612d, aVar.f6616h, aVar.i);
        this.f6615g = aVar.f6615g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6615g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public boolean a(a aVar) {
        return this.f6609a == aVar.f6609a && this.f6610b == aVar.f6610b && this.f6612d == aVar.f6612d && this.f6611c == aVar.f6611c;
    }

    public boolean b() {
        return this.f6609a > -1 && this.f6610b > 0;
    }

    public boolean c() {
        return this.f6609a == -1 && this.f6610b == -1 && this.f6612d == -1 && this.f6611c == -1;
    }

    public boolean d() {
        return this.f6609a > -1 && this.f6610b > -1 && this.f6612d == -1 && this.f6611c == -1;
    }

    public boolean e() {
        return this.f6609a > -1 && this.f6610b > -1 && this.f6612d > -1 && this.f6611c > -1;
    }

    public void f() {
        this.k = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6611c), Integer.valueOf(this.f6612d), Integer.valueOf(this.f6609a), Integer.valueOf(this.f6610b), Integer.valueOf(this.f6616h)));
        if (this.k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6611c), Integer.valueOf(this.f6612d), Integer.valueOf(this.f6609a), Integer.valueOf(this.f6610b), Integer.valueOf(this.f6616h)));
        return stringBuffer.toString();
    }
}
