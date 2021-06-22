package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.d;
/* loaded from: classes2.dex */
public class Report {

    /* renamed from: a  reason: collision with root package name */
    public static Report f10397a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10398b;

    public Report(Context context) {
        this.f10398b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (f10397a == null) {
                f10397a = new Report(context);
            }
            report = f10397a;
        }
        return report;
    }

    public void fr() {
        try {
            d a2 = d.a(this.f10398b);
            Message message = new Message();
            message.what = 9;
            a2.f10410b.a(message);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            c.a(this.f10398b, str, str2, str3, str4, str5);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public void n() {
        try {
            d a2 = d.a(this.f10398b);
            Message message = new Message();
            message.what = 6;
            a2.f10410b.a(message);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public void r(boolean z) {
        try {
            d.a(this.f10398b).a();
        } catch (Throwable unused) {
            c.a();
        }
    }

    public void s(String str) {
        s(str, c.e());
    }

    public void sr(String str) {
        try {
            d a2 = d.a(this.f10398b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a2.f10410b.a(message);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public void w(String str) {
        try {
            c.a(this.f10398b, str);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public void s(String str, boolean z) {
        try {
            c.a(this.f10398b, str, z);
        } catch (Throwable unused) {
            c.a();
        }
    }
}
