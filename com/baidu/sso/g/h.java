package com.baidu.sso.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.a.k0.l.c;
/* loaded from: classes2.dex */
public class h extends BroadcastReceiver {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10468e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10469f;

        public a(h hVar, String str, Context context) {
            this.f10468e = str;
            this.f10469f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("sso_action_t_m".equals(this.f10468e)) {
                    c.m(this.f10469f);
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(this.f10468e) && c.k(this.f10469f) != 0 && d.a.k0.b.c.b(this.f10469f).f()) {
                    d.a.k0.e.c.j().g(this.f10469f.getApplicationContext(), false);
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
        d.a.k0.h.a.a().post(new a(this, intent.getAction(), context));
    }
}
