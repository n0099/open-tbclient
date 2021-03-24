package com.baidu.platform.comapi.walknavi.g.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10106a;

    public o(c cVar) {
        this.f10106a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean e2;
        z = this.f10106a.X;
        if (z) {
            this.f10106a.X = false;
            String a2 = com.baidu.platform.comapi.walknavi.b.a().H().a("walknavi_current_npc_token", "");
            if (!TextUtils.isEmpty(a2)) {
                e2 = this.f10106a.e(a2);
                if (e2) {
                    this.f10106a.a(a2, new p(this));
                    return;
                }
            }
        } else if (!TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.d.e.c().a())) {
            this.f10106a.i();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a("");
        this.f10106a.b(true);
        com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
        this.f10106a.o();
    }
}
