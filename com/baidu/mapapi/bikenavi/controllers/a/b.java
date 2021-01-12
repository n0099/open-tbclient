package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
/* loaded from: classes6.dex */
class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBEngineInitListener f2665a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f2666b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IBEngineInitListener iBEngineInitListener) {
        this.f2666b = aVar;
        this.f2665a = iBEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f2665a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f2665a.engineInitFail();
    }
}
