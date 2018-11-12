package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
/* loaded from: classes4.dex */
class b implements com.baidu.platform.comapi.walknavi.c.a {
    final /* synthetic */ IBEngineInitListener a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IBEngineInitListener iBEngineInitListener) {
        this.b = aVar;
        this.a = iBEngineInitListener;
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
