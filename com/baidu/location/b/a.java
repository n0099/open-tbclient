package com.baidu.location.b;

import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f6871a;

    /* renamed from: b  reason: collision with root package name */
    public int f6872b;

    /* renamed from: c  reason: collision with root package name */
    public int f6873c;

    /* renamed from: d  reason: collision with root package name */
    public int f6874d;

    /* renamed from: e  reason: collision with root package name */
    public int f6875e;

    /* renamed from: f  reason: collision with root package name */
    public int f6876f;

    /* renamed from: g  reason: collision with root package name */
    public long f6877g;

    /* renamed from: h  reason: collision with root package name */
    public int f6878h;

    /* renamed from: i  reason: collision with root package name */
    public char f6879i;
    public String j;
    public boolean k;

    public a() {
        this.f6871a = -1;
        this.f6872b = -1;
        this.f6873c = -1;
        this.f6874d = -1;
        this.f6875e = Integer.MAX_VALUE;
        this.f6876f = Integer.MAX_VALUE;
        this.f6877g = 0L;
        this.f6878h = -1;
        this.f6879i = '0';
        this.j = null;
        this.k = false;
        this.f6877g = System.currentTimeMillis();
    }

    public a(int i2, int i3, int i4, int i5, int i6, char c2) {
        this.f6871a = -1;
        this.f6872b = -1;
        this.f6873c = -1;
        this.f6874d = -1;
        this.f6875e = Integer.MAX_VALUE;
        this.f6876f = Integer.MAX_VALUE;
        this.f6877g = 0L;
        this.f6878h = -1;
        this.f6879i = '0';
        this.j = null;
        this.k = false;
        this.f6871a = i2;
        this.f6872b = i3;
        this.f6873c = i4;
        this.f6874d = i5;
        this.f6878h = i6;
        this.f6879i = c2;
        this.f6877g = System.currentTimeMillis();
    }

    public a(a aVar) {
        this(aVar.f6871a, aVar.f6872b, aVar.f6873c, aVar.f6874d, aVar.f6878h, aVar.f6879i);
        this.f6877g = aVar.f6877g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6877g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    public boolean a(a aVar) {
        return this.f6871a == aVar.f6871a && this.f6872b == aVar.f6872b && this.f6874d == aVar.f6874d && this.f6873c == aVar.f6873c;
    }

    public boolean b() {
        return this.f6871a > -1 && this.f6872b > 0;
    }

    public boolean c() {
        return this.f6871a == -1 && this.f6872b == -1 && this.f6874d == -1 && this.f6873c == -1;
    }

    public boolean d() {
        return this.f6871a > -1 && this.f6872b > -1 && this.f6874d == -1 && this.f6873c == -1;
    }

    public boolean e() {
        return this.f6871a > -1 && this.f6872b > -1 && this.f6874d > -1 && this.f6873c > -1;
    }

    public void f() {
        this.k = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f6879i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f6873c), Integer.valueOf(this.f6874d), Integer.valueOf(this.f6871a), Integer.valueOf(this.f6872b), Integer.valueOf(this.f6878h)));
        if (this.k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.f6879i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f6873c), Integer.valueOf(this.f6874d), Integer.valueOf(this.f6871a), Integer.valueOf(this.f6872b), Integer.valueOf(this.f6878h)));
        return stringBuffer.toString();
    }
}
