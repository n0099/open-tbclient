package com.baidu.sofire.rp;

import android.content.Context;
import com.baidu.sofire.rp.f.b;
import com.baidu.sofire.rp.f.c;
/* loaded from: classes.dex */
public class Report {
    private static Report Qf;
    private Context b;

    private Report(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (Qf == null) {
                Qf = new Report(context);
            }
            report = Qf;
        }
        return report;
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            b.a(this.b, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            b.a();
        }
    }

    public void s(String str) {
        try {
            String str2 = str;
            b.b(this.b, str);
        } catch (Throwable th) {
            b.a();
        }
    }

    public void r(boolean z) {
        try {
            c.av(this.b).a();
        } catch (Throwable th) {
            b.a();
        }
    }

    public void w(String str) {
        try {
            b.c(this.b, str);
        } catch (Throwable th) {
            b.a();
        }
    }

    public void b(String str, String str2) {
        try {
            b.e(this.b, str, str2);
        } catch (Throwable th) {
            b.a();
        }
    }

    public void n() {
        try {
            c.av(this.b).e();
        } catch (Throwable th) {
            b.a();
        }
    }

    public void fr() {
        try {
            c.av(this.b).f();
        } catch (Throwable th) {
            b.a();
        }
    }
}
