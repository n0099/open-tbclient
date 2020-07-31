package com.baidu.platform.comapi.walknavi.g.b;

import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class o implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean e;
        z = this.a.X;
        if (z) {
            this.a.X = false;
            String a = com.baidu.platform.comapi.walknavi.b.a().H().a("walknavi_current_npc_token", "");
            if (!TextUtils.isEmpty(a)) {
                e = this.a.e(a);
                if (e) {
                    this.a.a(a, new p(this));
                    return;
                }
            }
        } else if (!TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.d.e.c().a())) {
            this.a.i();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a("");
        this.a.b(true);
        com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
        this.a.o();
    }
}
