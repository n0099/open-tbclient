package com.baidu.location.c;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.android.imsdk.internal.IMConnection;
import java.util.Locale;
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1923a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public int j;
    public int k;
    public String l;
    public String m;
    private boolean n;

    public a() {
        this.f1923a = -1;
        this.b = -1L;
        this.c = -1;
        this.d = -1;
        this.e = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.g = 0L;
        this.h = -1;
        this.i = '0';
        this.j = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = false;
        this.g = System.currentTimeMillis();
    }

    public a(int i, long j, int i2, int i3, int i4, char c, int i5) {
        this.f1923a = -1;
        this.b = -1L;
        this.c = -1;
        this.d = -1;
        this.e = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.g = 0L;
        this.h = -1;
        this.i = '0';
        this.j = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = false;
        this.f1923a = i;
        this.b = j;
        this.c = i2;
        this.d = i3;
        this.h = i4;
        this.i = c;
        this.g = System.currentTimeMillis();
        this.j = i5;
    }

    public a(a aVar) {
        this(aVar.f1923a, aVar.b, aVar.c, aVar.d, aVar.h, aVar.i, aVar.j);
        this.g = aVar.g;
        this.l = aVar.l;
        this.k = aVar.k;
        this.m = aVar.m;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.g > 0 && currentTimeMillis - this.g < IMConnection.RETRY_DELAY_TIMES;
    }

    public boolean a(a aVar) {
        return this.f1923a == aVar.f1923a && this.b == aVar.b && this.d == aVar.d && this.c == aVar.c;
    }

    public boolean b() {
        return this.f1923a > -1 && this.b > 0;
    }

    public boolean c() {
        return this.f1923a == -1 && this.b == -1 && this.d == -1 && this.c == -1;
    }

    public boolean d() {
        return this.f1923a > -1 && this.b > -1 && this.d == -1 && this.c == -1;
    }

    public boolean e() {
        return this.f1923a > -1 && this.b > -1 && this.d > -1 && this.c > -1;
    }

    public void f() {
        this.n = true;
    }

    public String g() {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.f1923a), Long.valueOf(this.b));
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d&clp=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.f1923a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.k)));
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(this.j);
        }
        if (this.n) {
            stringBuffer.append("&newcl=1");
        }
        if (this.m != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(this.m);
        }
        return stringBuffer.toString();
    }

    public String i() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.f1923a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.k)));
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(this.j);
        }
        if (this.m != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(this.m);
        }
        return stringBuffer.toString();
    }
}
