package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;
/* loaded from: classes3.dex */
class c implements com.baidu.platform.comapi.wnplatform.j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBRoutePlanListener f2758a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f2759b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IBRoutePlanListener iBRoutePlanListener) {
        this.f2759b = aVar;
        this.f2758a = iBRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
        this.f2758a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        this.f2758a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        switch (i) {
            case 16777214:
                this.f2758a.onRoutePlanFail(BikeRoutePlanError.FORWARD_AK_ERROR);
                return;
            case 16777216:
                this.f2758a.onRoutePlanFail(BikeRoutePlanError.SERVER_UNUSUAL);
                return;
            case 805306368:
                this.f2758a.onRoutePlanFail(BikeRoutePlanError.NET_ERR);
                return;
            default:
                this.f2758a.onRoutePlanFail(BikeRoutePlanError.PARSE_FAIL);
                return;
        }
    }
}
