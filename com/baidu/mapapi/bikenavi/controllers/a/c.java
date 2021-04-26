package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;
/* loaded from: classes2.dex */
public class c implements com.baidu.platform.comapi.wnplatform.i.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBRoutePlanListener f7020a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f7021b;

    public c(a aVar, IBRoutePlanListener iBRoutePlanListener) {
        this.f7021b = aVar;
        this.f7020a = iBRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        this.f7020a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        this.f7020a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i2) {
        if (i2 == 16777214) {
            this.f7020a.onRoutePlanFail(BikeRoutePlanError.FORWARD_AK_ERROR);
        } else if (i2 == 16777216) {
            this.f7020a.onRoutePlanFail(BikeRoutePlanError.SERVER_UNUSUAL);
        } else if (i2 != 805306368) {
            this.f7020a.onRoutePlanFail(BikeRoutePlanError.PARSE_FAIL);
        } else {
            this.f7020a.onRoutePlanFail(BikeRoutePlanError.NET_ERR);
        }
    }
}
