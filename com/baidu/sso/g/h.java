package com.baidu.sso.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.a.j0.l.c;
/* loaded from: classes2.dex */
public class h extends BroadcastReceiver {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10325f;

        public a(h hVar, String str, Context context) {
            this.f10324e = str;
            this.f10325f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("sso_action_t_m".equals(this.f10324e)) {
                    c.m(this.f10325f);
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(this.f10324e) && c.k(this.f10325f) != 0 && d.a.j0.b.c.b(this.f10325f).f()) {
                    d.a.j0.e.c.i().g(this.f10325f.getApplicationContext(), false);
                }
            } catch (Throwable th) {
                c.d(th);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        d.a.j0.h.a.a().post(new a(this, intent.getAction(), context));
    }
}
