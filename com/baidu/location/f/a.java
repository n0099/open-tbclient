package com.baidu.location.f;

import android.support.v7.widget.ActivityChooserView;
import java.util.Locale;
import org.apache.http.HttpStatus;
/* loaded from: classes.dex */
public class a {
    public char PR;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    private boolean j;

    public a() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.g = 0L;
        this.h = -1;
        this.PR = (char) 0;
        this.j = false;
        this.g = System.currentTimeMillis();
    }

    public a(int i, int i2, int i3, int i4, int i5, char c) {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.g = 0L;
        this.h = -1;
        this.PR = (char) 0;
        this.j = false;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.h = i5;
        this.PR = c;
        this.g = System.currentTimeMillis();
    }

    public a(a aVar) {
        this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.h, aVar.PR);
        this.g = aVar.g;
    }

    public boolean a() {
        return System.currentTimeMillis() - this.g < 3000;
    }

    public boolean a(a aVar) {
        return this.a == aVar.a && this.b == aVar.b && this.d == aVar.d && this.c == aVar.c;
    }

    public boolean b() {
        return this.a > -1 && this.b > 0;
    }

    public boolean c() {
        return this.a == -1 && this.b == -1 && this.d == -1 && this.c == -1;
    }

    public boolean d() {
        return this.a > -1 && this.b > -1 && this.d == -1 && this.c == -1;
    }

    public boolean e() {
        return this.a > -1 && this.b > -1 && this.d > -1 && this.c > -1;
    }

    public void f() {
        this.j = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.c + HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION);
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.PR);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.h)));
        if (this.j) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }
}
