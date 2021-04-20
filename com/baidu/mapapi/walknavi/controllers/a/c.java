package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* loaded from: classes2.dex */
public class c implements com.baidu.platform.comapi.wnplatform.i.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IWRoutePlanListener f7469a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f7470b;

    public c(a aVar, IWRoutePlanListener iWRoutePlanListener) {
        this.f7470b = aVar;
        this.f7469a = iWRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        this.f7469a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        this.f7469a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
        if (i == 16777214) {
            this.f7469a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
        } else if (i == 16777216) {
            this.f7469a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
        } else if (i != 805306368) {
            this.f7469a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
        } else {
            this.f7469a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
        }
    }
}
