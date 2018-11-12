package com.baidu.sofire.rp;

import android.content.Context;
import com.baidu.sofire.b;
import com.baidu.sofire.b.e;
import com.baidu.sofire.b.f;
/* loaded from: classes.dex */
public class Report {
    private static Report a;
    private Context b;

    private Report(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (a == null) {
                a = new Report(context);
            }
            report = a;
        }
        return report;
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            e.a(this.b, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void s(String str) {
        try {
            b.a("send log : " + str);
            e.b(this.b, str);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void sr(String str) {
        try {
            b.a("send log : " + str);
            f.a(this.b).a(str);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void r(boolean z) {
        try {
            f.a(this.b).a(z);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void w(String str) {
        try {
            e.c(this.b, str);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void n() {
        try {
            f.a(this.b).d();
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public void fr() {
        try {
            f.a(this.b).e();
        } catch (Throwable th) {
            e.a(th);
        }
    }
}
