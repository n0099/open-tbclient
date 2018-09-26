package cn.jiguang.g.a;

import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.d.b.d;
import cn.jiguang.d.d.e;
import cn.jiguang.d.d.l;
import cn.jiguang.e.c;
/* loaded from: classes3.dex */
public final class a extends cn.jiguang.b.b {
    private static cn.jiguang.b.a b;
    private static boolean a = false;
    private static final IBinder.DeathRecipient c = new b();

    public static void a(cn.jiguang.b.a aVar) {
        if (aVar != b) {
            if (b != null) {
                try {
                    b.asBinder().unlinkToDeath(c, 0);
                } catch (Throwable th) {
                }
            }
            b = aVar;
            try {
                b.asBinder().linkToDeath(c, 0);
            } catch (Throwable th2) {
            }
        }
        a = false;
    }

    public static cn.jiguang.b.a b() {
        return b;
    }

    public static boolean c() {
        return b != null;
    }

    public static boolean d() {
        return a;
    }

    public static void e() {
        a = true;
    }

    @Override // cn.jiguang.b.a
    public final IBinder a(String str, String str2) {
        e.bD();
        return e.h(str, str2);
    }

    @Override // cn.jiguang.b.a
    public final void a(String str, Bundle bundle) {
        if (str == null || bundle == null) {
            return;
        }
        try {
            l.bI().a(cn.jiguang.d.a.d, str, bundle);
        } catch (Throwable th) {
            c.c("DataShare", "onAction error:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.b.a
    public final boolean a() {
        d.bx();
        return d.d();
    }
}
