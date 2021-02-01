package com.baidu.platform.comapi.walknavi.g.b;

import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4315a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.f4315a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean e;
        z = this.f4315a.X;
        if (z) {
            this.f4315a.X = false;
            String a2 = com.baidu.platform.comapi.walknavi.b.a().H().a("walknavi_current_npc_token", "");
            if (!TextUtils.isEmpty(a2)) {
                e = this.f4315a.e(a2);
                if (e) {
                    this.f4315a.a(a2, new p(this));
                    return;
                }
            }
        } else if (!TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.d.e.c().a())) {
            this.f4315a.i();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a("");
        this.f4315a.b(true);
        com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
        this.f4315a.o();
    }
}
