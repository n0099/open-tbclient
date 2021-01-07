package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.sofire.b;
import com.baidu.sofire.i.e;
import com.baidu.sofire.i.g;
/* loaded from: classes15.dex */
public class Report {

    /* renamed from: a  reason: collision with root package name */
    private static Report f5601a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5602b;

    private Report(Context context) {
        this.f5602b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (f5601a == null) {
                f5601a = new Report(context);
            }
            report = f5601a;
        }
        return report;
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            e.a(this.f5602b, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void s(String str) {
        try {
            new StringBuilder().append(str);
            b.a();
            e.a(this.f5602b, str);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void sr(String str) {
        try {
            new StringBuilder().append(str);
            b.a();
            g a2 = g.a(this.f5602b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a2.f5540a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void r(boolean z) {
        try {
            g.a(this.f5602b).a();
        } catch (Throwable th) {
            e.a();
        }
    }

    public void w(String str) {
        try {
            e.b(this.f5602b, str);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void n() {
        try {
            g a2 = g.a(this.f5602b);
            Message message = new Message();
            message.what = 6;
            a2.f5540a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }

    public void fr() {
        try {
            g a2 = g.a(this.f5602b);
            Message message = new Message();
            message.what = 9;
            a2.f5540a.a(message);
        } catch (Throwable th) {
            e.a();
        }
    }
}
