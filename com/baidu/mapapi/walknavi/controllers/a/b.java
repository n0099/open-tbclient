package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
/* loaded from: classes2.dex */
public class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IWEngineInitListener f7431a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f7432b;

    public b(a aVar, IWEngineInitListener iWEngineInitListener) {
        this.f7432b = aVar;
        this.f7431a = iWEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f7431a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f7431a.engineInitFail();
    }
}
