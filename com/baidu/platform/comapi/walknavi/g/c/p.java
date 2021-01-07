package com.baidu.platform.comapi.walknavi.g.c;

import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* loaded from: classes3.dex */
class p implements c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f4535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f4535a = oVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4535a.f4534a.Y;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f4535a.f4534a.Y;
            iWNPCLoadAndInitListener2.onSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f4535a.f4534a.Y;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f4535a.f4534a.b(true);
            com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
            this.f4535a.f4534a.s();
            iWNPCLoadAndInitListener2 = this.f4535a.f4534a.Y;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
