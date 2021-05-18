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
        public final /* synthetic */ String f10423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10424f;

        public a(h hVar, String str, Context context) {
            this.f10423e = str;
            this.f10424f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("sso_action_t_m".equals(this.f10423e)) {
                    c.m(this.f10424f);
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(this.f10423e) && c.k(this.f10424f) != 0 && d.a.g0.b.c.b(this.f10424f).f()) {
                    d.a.g0.e.c.i().g(this.f10424f.getApplicationContext(), false);
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
