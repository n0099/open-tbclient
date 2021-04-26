package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
/* loaded from: classes2.dex */
public class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBEngineInitListener f7018a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f7019b;

    public b(a aVar, IBEngineInitListener iBEngineInitListener) {
        this.f7019b = aVar;
        this.f7018a = iBEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f7018a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f7018a.engineInitFail();
    }
}
