package com.baidu.platform.comapi.walknavi.g.b;

import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* loaded from: classes6.dex */
class p implements c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f4313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f4313a = oVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4313a.f4312a.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f4313a.f4312a.W;
            iWNPCLoadAndInitListener2.onSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4313a.f4312a.W;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f4313a.f4312a.b(true);
            com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
            this.f4313a.f4312a.o();
            iWNPCLoadAndInitListener2 = this.f4313a.f4312a.W;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
