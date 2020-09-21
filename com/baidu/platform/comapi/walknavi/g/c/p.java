package com.baidu.platform.comapi.walknavi.g.c;

import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.platform.comapi.walknavi.g.c.c;
/* loaded from: classes3.dex */
class p implements c.d {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.a.a.Y;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.a.a.Y;
            iWNPCLoadAndInitListener2.onSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.a.a.Y;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.a.a.b(true);
            com.baidu.platform.comapi.walknavi.b.a().G().a(0, 0);
            this.a.a.s();
            iWNPCLoadAndInitListener2 = this.a.a.Y;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
