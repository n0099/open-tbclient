package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;
/* loaded from: classes2.dex */
public class c implements com.baidu.platform.comapi.wnplatform.i.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBRoutePlanListener f6748a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f6749b;

    public c(a aVar, IBRoutePlanListener iBRoutePlanListener) {
        this.f6749b = aVar;
        this.f6748a = iBRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        this.f6748a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        this.f6748a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
        if (i == 16777214) {
            this.f6748a.onRoutePlanFail(BikeRoutePlanError.FORWARD_AK_ERROR);
        } else if (i == 16777216) {
            this.f6748a.onRoutePlanFail(BikeRoutePlanError.SERVER_UNUSUAL);
        } else if (i != 805306368) {
            this.f6748a.onRoutePlanFail(BikeRoutePlanError.PARSE_FAIL);
        } else {
            this.f6748a.onRoutePlanFail(BikeRoutePlanError.NET_ERR);
        }
    }
}
