package com.baidu.sso.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.a.g0.l.c;
/* loaded from: classes2.dex */
public class h extends BroadcastReceiver {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f11357f;

        public a(h hVar, String str, Context context) {
            this.f11356e = str;
            this.f11357f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("sso_action_t_m".equals(this.f11356e)) {
                    c.m(this.f11357f);
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(this.f11356e) && c.k(this.f11357f) != 0 && d.a.g0.b.c.b(this.f11357f).f()) {
                    d.a.g0.e.c.i().g(this.f11357f.getApplicationContext(), false);
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
        d.a.g0.h.a.a().post(new a(this, intent.getAction(), context));
    }
}
