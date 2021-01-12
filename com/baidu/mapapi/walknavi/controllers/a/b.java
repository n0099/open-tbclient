package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
/* loaded from: classes6.dex */
class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWEngineInitListener f2981a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f2982b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IWEngineInitListener iWEngineInitListener) {
        this.f2982b = aVar;
        this.f2981a = iWEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f2981a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f2981a.engineInitFail();
    }
}
