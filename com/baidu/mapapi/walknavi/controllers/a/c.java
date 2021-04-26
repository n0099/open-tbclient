package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* loaded from: classes2.dex */
public class c implements com.baidu.platform.comapi.wnplatform.i.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IWRoutePlanListener f7736a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f7737b;

    public c(a aVar, IWRoutePlanListener iWRoutePlanListener) {
        this.f7737b = aVar;
        this.f7736a = iWRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        this.f7736a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        this.f7736a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i2) {
        if (i2 == 16777214) {
            this.f7736a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
        } else if (i2 == 16777216) {
            this.f7736a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
        } else if (i2 != 805306368) {
            this.f7736a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        } else {
            this.f7736a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
        }
    }
}
