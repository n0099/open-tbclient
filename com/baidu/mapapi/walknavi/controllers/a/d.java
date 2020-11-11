package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements com.baidu.platform.comapi.wnplatform.j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWNaviCalcRouteListener f2174a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        this.b = aVar;
        this.f2174a = iWNaviCalcRouteListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        if (this.f2174a != null) {
            this.f2174a.onNaviCalcRouteSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        if (this.f2174a != null) {
            this.f2174a.onNaviCalcRouteFail(WalkRoutePlanError.PARSE_FAIL);
        }
    }
}
