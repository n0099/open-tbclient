package com.baidu.platform.comapi.walknavi.g.b;

import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* loaded from: classes4.dex */
class p implements c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f2986a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f2986a = oVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f2986a.f2985a.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f2986a.f2985a.W;
            iWNPCLoadAndInitListener2.onSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f2986a.f2985a.W;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f2986a.f2985a.b(true);
            com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
            this.f2986a.f2985a.o();
            iWNPCLoadAndInitListener2 = this.f2986a.f2985a.W;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
