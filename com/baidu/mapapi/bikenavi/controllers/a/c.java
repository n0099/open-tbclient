package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;
/* loaded from: classes7.dex */
class c implements com.baidu.platform.comapi.wnplatform.j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBRoutePlanListener f1976a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IBRoutePlanListener iBRoutePlanListener) {
        this.b = aVar;
        this.f1976a = iBRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
        this.f1976a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        this.f1976a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        switch (i) {
            case 16777214:
                this.f1976a.onRoutePlanFail(BikeRoutePlanError.FORWARD_AK_ERROR);
                return;
            case 16777216:
                this.f1976a.onRoutePlanFail(BikeRoutePlanError.SERVER_UNUSUAL);
                return;
            case 805306368:
                this.f1976a.onRoutePlanFail(BikeRoutePlanError.NET_ERR);
                return;
            default:
                this.f1976a.onRoutePlanFail(BikeRoutePlanError.PARSE_FAIL);
                return;
        }
    }
}
