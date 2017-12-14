package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.sofire.b.d;
import com.baidu.sofire.rp.f.a;
import com.baidu.sofire.rp.f.b;
/* loaded from: classes.dex */
public class Report {
    private static Report QE;
    private Context b;

    private Report(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (QE == null) {
                QE = new Report(context);
            }
            report = QE;
        }
        return report;
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            a.a(this.b, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void s(String str) {
        try {
            a.a(this.b, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void sr(String str) {
        try {
            b at = b.at(this.b);
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            at.QO.QK.sendMessage(message);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void r(boolean z) {
        try {
            b.at(this.b).a();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void w(String str) {
        try {
            a.b(this.b, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void n() {
        try {
            b at = b.at(this.b);
            Message message = new Message();
            message.what = 6;
            at.QO.QK.sendMessage(message);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void fr() {
        try {
            b at = b.at(this.b);
            Message message = new Message();
            message.what = 9;
            at.QO.QK.sendMessage(message);
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
