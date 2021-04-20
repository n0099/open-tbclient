package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.sofire.b;
import com.baidu.sofire.g.d;
import com.baidu.sofire.g.e;
/* loaded from: classes2.dex */
public class Report {

    /* renamed from: a  reason: collision with root package name */
    public static Report f11519a;

    /* renamed from: b  reason: collision with root package name */
    public Context f11520b;

    public Report(Context context) {
        this.f11520b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (f11519a == null) {
                f11519a = new Report(context);
            }
            report = f11519a;
        }
        return report;
    }

    public void fr() {
        try {
            e a2 = e.a(this.f11520b);
            Message message = new Message();
            message.what = 9;
            a2.f11419b.a(message);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            d.a(this.f11520b, str, str2, str3, str4, str5);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public void n() {
        try {
            e a2 = e.a(this.f11520b);
            Message message = new Message();
            message.what = 6;
            a2.f11419b.a(message);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public void r(boolean z) {
        try {
            e.a(this.f11520b).a();
        } catch (Throwable unused) {
            d.a();
        }
    }

    public void s(String str) {
        s(str, false);
    }

    public void sr(String str) {
        try {
            new StringBuilder().append(str);
            b.a();
            e a2 = e.a(this.f11520b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a2.f11419b.a(message);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public void w(String str) {
        try {
            d.a(this.f11520b, str);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public void s(String str, boolean z) {
        try {
            new StringBuilder().append(str);
            b.a();
            d.a(this.f11520b, str, z);
        } catch (Throwable unused) {
            d.a();
        }
    }
}
