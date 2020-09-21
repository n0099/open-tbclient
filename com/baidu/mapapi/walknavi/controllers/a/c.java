package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements com.baidu.platform.comapi.wnplatform.j.c {
    final /* synthetic */ IWRoutePlanListener a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, IWRoutePlanListener iWRoutePlanListener) {
        this.b = aVar;
        this.a = iWRoutePlanListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
        this.a.onRoutePlanStart();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        this.a.onRoutePlanSuccess();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
        switch (i) {
            case 16777214:
                this.a.onRoutePlanFail(WalkRoutePlanError.FORWARD_AK_ERROR);
                return;
            case 16777216:
                this.a.onRoutePlanFail(WalkRoutePlanError.SERVER_UNUSUAL);
                return;
            case 805306368:
                this.a.onRoutePlanFail(WalkRoutePlanError.NET_ERR);
                return;
            default:
                this.a.onRoutePlanFail(WalkRoutePlanError.PARSE_FAIL);
                return;
        }
    }
}
