package com.baidu.location.b;

import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f6608a;

    /* renamed from: b  reason: collision with root package name */
    public int f6609b;

    /* renamed from: c  reason: collision with root package name */
    public int f6610c;

    /* renamed from: d  reason: collision with root package name */
    public int f6611d;

    /* renamed from: e  reason: collision with root package name */
    public int f6612e;

    /* renamed from: f  reason: collision with root package name */
    public int f6613f;

    /* renamed from: g  reason: collision with root package name */
    public long f6614g;

    /* renamed from: h  reason: collision with root package name */
    public int f6615h;
    public char i;
    public String j;
    public boolean k;

    public a() {
        this.f6608a = -1;
        this.f6609b = -1;
        this.f6610c = -1;
        this.f6611d = -1;
        this.f6612e = Integer.MAX_VALUE;
        this.f6613f = Integer.MAX_VALUE;
        this.f6614g = 0L;
        this.f6615h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.f6614g = System.currentTimeMillis();
    }

    public a(int i, int i2, int i3, int i4, int i5, char c2) {
        this.f6608a = -1;
        this.f6609b = -1;
        this.f6610c = -1;
        this.f6611d = -1;
        this.f6612e = Integer.MAX_VALUE;
        this.f6613f = Integer.MAX_VALUE;
        this.f6614g = 0L;
        this.f6615h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.f6608a = i;
        this.f6609b = i2;
        this.f6610c = i3;
        this.f6611d = i4;
        this.f6615h = i5;
        this.i = c2;
        this.f6614g = System.currentTimeMillis();
    }

    public a(a aVar) {
        this(aVar.f6608a, aVar.f6609b, aVar.f6610c, aVar.f6611d, aVar.f6615h, aVar.i);
        this.f6614g = aVar.f6614g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6614g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public boolean a(a aVar) {
        return this.f6608a == aVar.f6608a && this.f6609b == aVar.f6609b && this.f6611d == aVar.f6611d && this.f6610c == aVar.f6610c;
    }

    public boolean b() {
        return this.f6608a > -1 && this.f6609b > 0;
    }

    public boolean c() {
        return this.f6608a == -1 && this.f6609b == -1 && this.f6611d == -1 && this.f6610c == -1;
    }

    public boolean d() {
        return this.f6608a > -1 && this.f6609b > -1 && this.f6611d == -1 && this.f6610c == -1;
    }

    public boolean e() {
        return this.f6608a > -1 && this.f6609b > -1 && this.f6611d > -1 && this.f6610c > -1;
    }

    public void f() {
        this.k = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6610c), Integer.valueOf(this.f6611d), Integer.valueOf(this.f6608a), Integer.valueOf(this.f6609b), Integer.valueOf(this.f6615h)));
        if (this.k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6610c), Integer.valueOf(this.f6611d), Integer.valueOf(this.f6608a), Integer.valueOf(this.f6609b), Integer.valueOf(this.f6615h)));
        return stringBuffer.toString();
    }
}
