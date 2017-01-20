package com.baidu.location.c;

import java.util.Locale;
/* loaded from: classes.dex */
public class g {
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private int e = 0;
    private String f = null;
    private String g = null;
    private String h = null;

    public void a() {
        this.a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(boolean z) {
        if (z) {
            this.e = 1;
        } else {
            this.e = 0;
        }
    }

    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        if (com.baidu.location.f.j.nb().g()) {
            this.f = "&cn=32";
        } else {
            this.f = String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.f.b.mS().e()));
        }
        stringBuffer.append(this.f);
        stringBuffer.append(String.format(Locale.CHINA, "&fir=%d&tim=%d&dsc=%d&det=%d&ded=%d&typ=%s", Integer.valueOf(this.e), Long.valueOf(this.a), Long.valueOf(this.b - this.a), Long.valueOf(this.c - this.b), Long.valueOf(this.d - this.c), this.g));
        if (this.h != null) {
            stringBuffer.append(this.h);
        }
        stringBuffer.append(com.baidu.location.h.c.nh().a(false));
        stringBuffer.append(com.baidu.location.a.a.mi().c());
        return stringBuffer.toString();
    }

    public void b(long j) {
        this.b = j;
    }

    public void b(String str) {
        if (this.h == null) {
            this.h = str;
        } else {
            this.h = String.format("%s%s", this.h, str);
        }
    }

    public void c(long j) {
        this.c = j;
    }

    public void l(long j) {
        this.d = j;
    }
}
