package com.baidu.platform.comapi.walknavi.g.b;

import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.platform.comapi.walknavi.g.b.c;
/* loaded from: classes2.dex */
public class p implements c.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f10026a;

    public p(o oVar) {
        this.f10026a = oVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void a() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f10026a.f10025a.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f10026a.f10025a.W;
            iWNPCLoadAndInitListener2.onSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.c.d
    public void b() {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f10026a.f10025a.W;
        if (iWNPCLoadAndInitListener != null) {
            com.baidu.platform.comapi.walknavi.d.e.c().a("");
            this.f10026a.f10025a.b(true);
            com.baidu.platform.comapi.walknavi.b.a().D().a(0, 0);
            this.f10026a.f10025a.o();
            iWNPCLoadAndInitListener2 = this.f10026a.f10025a.W;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
