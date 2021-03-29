package com.baidu.platform.comapi.walknavi.g.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10107a;

    public o(c cVar) {
        this.f10107a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean e2;
        z = this.f10107a.X;
        if (z) {
            this.f10107a.X = false;
            String a2 = com.baidu.platform.comapi.walknavi.b.a().H().a("walknavi_current_npc_token", "");
            if (!TextUtils.isEmpty(a2)) {
                e2 = this.f10107a.e(a2);
                if (e2) {
                    this.f10107a.a(a2, new p(this));
                    return;
                }
            }
        } else if (!TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.d.e.c().a())) {
            this.f10107a.i();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a("");
        this.f10107a.b(true);
        com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
        this.f10107a.o();
    }
}
