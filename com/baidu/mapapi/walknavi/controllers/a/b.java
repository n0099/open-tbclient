package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IWEngineInitListener f2174a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, IWEngineInitListener iWEngineInitListener) {
        this.b = aVar;
        this.f2174a = iWEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f2174a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f2174a.engineInitFail();
    }
}
