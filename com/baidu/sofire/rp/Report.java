package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
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
            e.a();
        }
    }

    public void s(String str) {
        try {
            b.a();
            e.b(this.b, str);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void sr(String str) {
        try {
            b.a();
            f a2 = f.a(this.b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a2.a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void r(boolean z) {
        try {
            f.a(this.b).a();
        } catch (Throwable th) {
            e.a();
        }
    }

    public void w(String str) {
        try {
            e.c(this.b, str);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void n() {
        try {
            f a2 = f.a(this.b);
            Message message = new Message();
            message.what = 6;
            a2.a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void fr() {
        try {
            f a2 = f.a(this.b);
            Message message = new Message();
            message.what = 9;
            a2.a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }
}
