package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.e;
/* loaded from: classes.dex */
public class Report {
    private static Report aGO;
    private Context b;

    private Report(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (aGO == null) {
                aGO = new Report(context);
            }
            report = aGO;
        }
        return report;
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            d.a(this.b, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void s(String str) {
        try {
            d.b(this.b, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void sr(String str) {
        try {
            e aB = e.aB(this.b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            aB.aGu.aGS.sendMessage(message);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void r(boolean z) {
        try {
            e.aB(this.b).a();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void w(String str) {
        try {
            d.c(this.b, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void n() {
        try {
            e aB = e.aB(this.b);
            Message message = new Message();
            message.what = 6;
            aB.aGu.aGS.sendMessage(message);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void fr() {
        try {
            e aB = e.aB(this.b);
            Message message = new Message();
            message.what = 9;
            aB.aGu.aGS.sendMessage(message);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
