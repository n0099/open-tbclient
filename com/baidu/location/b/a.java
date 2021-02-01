package com.baidu.location.b;

import com.baidu.android.imsdk.internal.IMConnection;
import java.util.Locale;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f2593a;

    /* renamed from: b  reason: collision with root package name */
    public int f2594b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public String j;
    private boolean k;

    public a() {
        this.f2593a = -1;
        this.f2594b = -1;
        this.c = -1;
        this.d = -1;
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.g = System.currentTimeMillis();
    }

    public a(int i, int i2, int i3, int i4, int i5, char c) {
        this.f2593a = -1;
        this.f2594b = -1;
        this.c = -1;
        this.d = -1;
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.f2593a = i;
        this.f2594b = i2;
        this.c = i3;
        this.d = i4;
        this.h = i5;
        this.i = c;
        this.g = System.currentTimeMillis();
    }

    public a(a aVar) {
        this(aVar.f2593a, aVar.f2594b, aVar.c, aVar.d, aVar.h, aVar.i);
        this.g = aVar.g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.g > 0 && currentTimeMillis - this.g < IMConnection.RETRY_DELAY_TIMES;
    }

    public boolean a(a aVar) {
        return this.f2593a == aVar.f2593a && this.f2594b == aVar.f2594b && this.d == aVar.d && this.c == aVar.c;
    }

    public boolean b() {
        return this.f2593a > -1 && this.f2594b > 0;
    }

    public boolean c() {
        return this.f2593a == -1 && this.f2594b == -1 && this.d == -1 && this.c == -1;
    }

    public boolean d() {
        return this.f2593a > -1 && this.f2594b > -1 && this.d == -1 && this.c == -1;
    }

    public boolean e() {
        return this.f2593a > -1 && this.f2594b > -1 && this.d > -1 && this.c > -1;
    }

    public void f() {
        this.k = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.f2593a), Integer.valueOf(this.f2594b), Integer.valueOf(this.h)));
        if (this.k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.f2593a), Integer.valueOf(this.f2594b), Integer.valueOf(this.h)));
        return stringBuffer.toString();
    }
}
