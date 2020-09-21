package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements com.baidu.platform.comapi.wnplatform.j.c {
    final /* synthetic */ IWNaviCalcRouteListener a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        this.b = aVar;
        this.a = iWNaviCalcRouteListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        if (this.a != null) {
            this.a.onNaviCalcRouteSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        if (this.a != null) {
            this.a.onNaviCalcRouteFail(WalkRoutePlanError.PARSE_FAIL);
        }
    }
}
