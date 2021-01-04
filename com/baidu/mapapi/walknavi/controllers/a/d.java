package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class d implements com.baidu.platform.comapi.wnplatform.j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWNaviCalcRouteListener f3090a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3091b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        this.f3091b = aVar;
        this.f3090a = iWNaviCalcRouteListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        if (this.f3090a != null) {
            this.f3090a.onNaviCalcRouteSuccess();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        if (this.f3090a != null) {
            this.f3090a.onNaviCalcRouteFail(WalkRoutePlanError.PARSE_FAIL);
        }
    }
}
