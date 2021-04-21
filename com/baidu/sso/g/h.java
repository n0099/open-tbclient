package com.baidu.sso.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.b.g0.l.c;
/* loaded from: classes2.dex */
public class h extends BroadcastReceiver {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11530e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f11531f;

        public a(h hVar, String str, Context context) {
            this.f11530e = str;
            this.f11531f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("sso_action_t_m".equals(this.f11530e)) {
                    c.m(this.f11531f);
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(this.f11530e) && c.k(this.f11531f) != 0 && d.b.g0.b.c.b(this.f11531f).f()) {
                    d.b.g0.e.c.i().g(this.f11531f.getApplicationContext(), false);
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
        d.b.g0.h.a.a().post(new a(this, intent.getAction(), context));
    }
}
