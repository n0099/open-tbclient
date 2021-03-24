package com.baidu.sso.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.b.f0.l.c;
/* loaded from: classes3.dex */
public class h extends BroadcastReceiver {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f11861f;

        public a(h hVar, String str, Context context) {
            this.f11860e = str;
            this.f11861f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("sso_action_t_m".equals(this.f11860e)) {
                    c.m(this.f11861f);
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(this.f11860e) && c.k(this.f11861f) != 0 && d.b.f0.b.c.b(this.f11861f).f()) {
                    d.b.f0.e.c.i().g(this.f11861f.getApplicationContext(), false);
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
        d.b.f0.h.a.a().post(new a(this, intent.getAction(), context));
    }
}
