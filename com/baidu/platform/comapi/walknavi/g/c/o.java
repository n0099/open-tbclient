package com.baidu.platform.comapi.walknavi.g.c;

import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3041a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.f3041a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean e;
        z = this.f3041a.Z;
        if (z) {
            this.f3041a.Z = false;
            String a2 = com.baidu.platform.comapi.walknavi.b.a().K().a("walknavi_current_npc_token", "");
            if (!TextUtils.isEmpty(a2)) {
                e = this.f3041a.e(a2);
                if (e) {
                    this.f3041a.a(a2, new p(this));
                    return;
                }
            }
        } else if (!TextUtils.isEmpty(com.baidu.platform.comapi.walknavi.d.e.c().a())) {
            this.f3041a.j();
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a("");
        this.f3041a.b(true);
        com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
        this.f3041a.s();
    }
}
