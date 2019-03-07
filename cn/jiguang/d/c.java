package cn.jiguang.d;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.a.a.c.e;
import cn.jiguang.d.d.aa;
/* loaded from: classes3.dex */
public final class c implements Runnable {
    public final Context a;
    public final int b;

    public c(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                a.e(this.a);
                break;
            case 1:
                break;
            case 2:
                if (a.d(this.a)) {
                    e bq = e.bq();
                    Context context = this.a;
                    if (bq.a) {
                        return;
                    }
                    bq.a = true;
                    cn.jiguang.d.a.d.a(a.X(context), true);
                    return;
                }
                return;
            case 3:
                if (a.d(this.a)) {
                    e bq2 = e.bq();
                    Context context2 = this.a;
                    if (bq2.a) {
                        bq2.a = false;
                        cn.jiguang.d.a.d.a(a.X(context2), false);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
        Context context3 = this.a;
        cn.jiguang.d.b.a.b();
        if (cn.jiguang.g.a.q(context3)) {
            a.a(context3, false);
        }
        aa.a(context3);
        Bundle bundle = new Bundle();
        bundle.putString("action", "cn.jpush.android.intent.REPORT");
        bundle.putString("report", "crash_log");
        bundle.putString("report.extra.info", "");
        cn.jiguang.api.e.b(context3, a.a, bundle);
    }
}
