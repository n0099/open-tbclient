package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.sofire.b;
import com.baidu.sofire.i.e;
import com.baidu.sofire.i.g;
/* loaded from: classes4.dex */
public class Report {

    /* renamed from: a  reason: collision with root package name */
    private static Report f3574a;
    private Context b;

    private Report(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (f3574a == null) {
                f3574a = new Report(context);
            }
            report = f3574a;
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
            new StringBuilder().append(str);
            b.a();
            e.a(this.b, str);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void sr(String str) {
        try {
            new StringBuilder().append(str);
            b.a();
            g a2 = g.a(this.b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a2.f3536a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void r(boolean z) {
        try {
            g.a(this.b).a();
        } catch (Throwable th) {
            e.a();
        }
    }

    public void w(String str) {
        try {
            e.b(this.b, str);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void n() {
        try {
            g a2 = g.a(this.b);
            Message message = new Message();
            message.what = 6;
            a2.f3536a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void fr() {
        try {
            g a2 = g.a(this.b);
            Message message = new Message();
            message.what = 9;
            a2.f3536a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }
}
