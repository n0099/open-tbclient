package com.baidu.platform.comapi.walknavi.g.c;

import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* loaded from: classes26.dex */
class p implements c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f3044a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f3044a = oVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f3044a.f3043a.Y;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f3044a.f3043a.Y;
            iWNPCLoadAndInitListener2.onSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f3044a.f3043a.Y;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f3044a.f3043a.b(true);
            com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
            this.f3044a.f3043a.s();
            iWNPCLoadAndInitListener2 = this.f3044a.f3043a.Y;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
