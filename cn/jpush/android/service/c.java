package cn.jpush.android.service;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, long j) {
        this.b = aVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        String str;
        try {
            context = this.b.d;
            cn.jpush.android.data.d a = cn.jpush.android.data.d.a(context);
            cn.jpush.android.data.e a2 = a.a(this.a, 0);
            if (a2 != null) {
                if (a2.c() == 1) {
                    a.b(a2.a(), 0, 1, 0, a2.d(), a2.f(), a2.e());
                } else if (a2.b() > 1) {
                    a.b(a2.a(), a2.b() - 1, 0, 0, a2.d(), a2.f(), a2.e());
                } else if (a2.b() == 1) {
                    if (a2.f() <= System.currentTimeMillis()) {
                        a aVar = this.b;
                        context2 = this.b.d;
                        String d = a2.d();
                        str = this.b.e;
                        aVar.a(context2, d, str, "");
                        a.b(a2.a(), 0, 0, 0, a2.d(), a2.f(), a2.e());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
