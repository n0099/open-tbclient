package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* loaded from: classes7.dex */
class d implements com.baidu.platform.comapi.wnplatform.j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWNaviCalcRouteListener f2172a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        this.b = aVar;
        this.f2172a = iWNaviCalcRouteListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        if (this.f2172a != null) {
            this.f2172a.onNaviCalcRouteSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        if (this.f2172a != null) {
            this.f2172a.onNaviCalcRouteFail(WalkRoutePlanError.PARSE_FAIL);
        }
    }
}
