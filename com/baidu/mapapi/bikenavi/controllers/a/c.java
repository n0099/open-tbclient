package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;
/* loaded from: classes6.dex */
class c implements com.baidu.platform.comapi.wnplatform.i.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBRoutePlanListener f2667a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f2668b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IBRoutePlanListener iBRoutePlanListener) {
        this.f2668b = aVar;
        this.f2667a = iBRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        this.f2667a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        this.f2667a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
        switch (i) {
            case 16777214:
                this.f2667a.onRoutePlanFail(BikeRoutePlanError.FORWARD_AK_ERROR);
                return;
            case 16777216:
                this.f2667a.onRoutePlanFail(BikeRoutePlanError.SERVER_UNUSUAL);
                return;
            case 805306368:
                this.f2667a.onRoutePlanFail(BikeRoutePlanError.NET_ERR);
                return;
            default:
                this.f2667a.onRoutePlanFail(BikeRoutePlanError.PARSE_FAIL);
                return;
        }
    }
}
