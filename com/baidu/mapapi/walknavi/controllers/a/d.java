package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class d implements com.baidu.platform.comapi.wnplatform.j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWNaviCalcRouteListener f2176a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        this.b = aVar;
        this.f2176a = iWNaviCalcRouteListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        if (this.f2176a != null) {
            this.f2176a.onNaviCalcRouteSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        if (this.f2176a != null) {
            this.f2176a.onNaviCalcRouteFail(WalkRoutePlanError.PARSE_FAIL);
        }
    }
}
