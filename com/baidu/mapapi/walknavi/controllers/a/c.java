package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* loaded from: classes4.dex */
class c implements com.baidu.platform.comapi.wnplatform.i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWRoutePlanListener f2177a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IWRoutePlanListener iWRoutePlanListener) {
        this.b = aVar;
        this.f2177a = iWRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        this.f2177a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        this.f2177a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
        switch (i) {
            case 16777214:
                this.f2177a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
                return;
            case 16777216:
                this.f2177a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
                return;
            case 805306368:
                this.f2177a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
                return;
            default:
                this.f2177a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
                return;
        }
    }
}
