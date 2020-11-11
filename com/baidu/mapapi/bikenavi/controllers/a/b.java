package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
/* loaded from: classes7.dex */
class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBEngineInitListener f1975a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IBEngineInitListener iBEngineInitListener) {
        this.b = aVar;
        this.f1975a = iBEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f1975a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f1975a.engineInitFail();
    }
}
