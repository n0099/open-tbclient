package com.baidu.mapapi.walknavi;

import com.baidu.g.a.d;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.wnplatform.j.b;
import com.baidu.platform.comapi.wnplatform.p.g;
/* loaded from: classes7.dex */
class a implements b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWRoutePlanListener f2170a;
    final /* synthetic */ WalkNaviLaunchParam b;
    final /* synthetic */ WalkNavigateHelper c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WalkNavigateHelper walkNavigateHelper, IWRoutePlanListener iWRoutePlanListener, WalkNaviLaunchParam walkNaviLaunchParam) {
        this.c = walkNavigateHelper;
        this.f2170a = iWRoutePlanListener;
        this.b = walkNaviLaunchParam;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.b
    public void a() {
        this.f2170a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.b
    public void b() {
        c a2;
        com.baidu.mapapi.walknavi.controllers.a.a aVar;
        c cVar;
        d Q = com.baidu.platform.comapi.walknavi.b.a().Q();
        if (Q == null || !Q.vM() || Q.wt() == null || !Q.wt().hasStart() || Q.wt().wE() == null || Q.wt().wE().xg() != 2 || !Q.wt().wE().wY() || Q.wt().wE().wX() == null) {
            this.f2170a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
            return;
        }
        if (g.a()) {
            this.c.d = true;
        }
        if (g.c()) {
            com.baidu.platform.comapi.wnplatform.a.a().a(true);
        } else {
            com.baidu.platform.comapi.wnplatform.a.a().a(false);
            if (g.d()) {
                this.f2170a.onRoutePlanFail(WalkRoutePlanError.IS_NOT_SUPPORT_INDOOR_NAVI);
                return;
            }
        }
        this.c.a(Q);
        WNavigatorWrapper.getWNavigator().d(1);
        WNavigatorWrapper.getWNavigator().e(this.b.getExtraNaviMode());
        WalkNavigateHelper walkNavigateHelper = this.c;
        a2 = this.c.a(Q, this.b);
        walkNavigateHelper.e = a2;
        aVar = this.c.f2169a;
        cVar = this.c.e;
        if (aVar.a(cVar)) {
            this.f2170a.onRoutePlanSuccess();
        } else {
            this.f2170a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.b
    public void a(int i) {
        switch (i) {
            case 16777214:
                this.f2170a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
                return;
            case 16777216:
                this.f2170a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
                return;
            case 805306368:
                this.f2170a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
                return;
            default:
                this.f2170a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
                return;
        }
    }
}
