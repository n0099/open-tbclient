package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
/* loaded from: classes6.dex */
class b implements com.baidu.platform.comapi.walknavi.c.a {
    final /* synthetic */ IWEngineInitListener a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IWEngineInitListener iWEngineInitListener) {
        this.b = aVar;
        this.a = iWEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.a.engineInitFail();
    }
}
