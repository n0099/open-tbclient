package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c implements com.baidu.platform.comapi.wnplatform.j.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWRoutePlanListener f3088a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3089b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IWRoutePlanListener iWRoutePlanListener) {
        this.f3089b = aVar;
        this.f3088a = iWRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
        this.f3088a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        this.f3088a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        switch (i) {
            case 16777214:
                this.f3088a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
                return;
            case 16777216:
                this.f3088a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
                return;
            case 805306368:
                this.f3088a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
                return;
            default:
                this.f3088a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
                return;
        }
    }
}
