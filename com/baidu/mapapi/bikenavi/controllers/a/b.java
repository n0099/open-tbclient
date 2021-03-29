package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
/* loaded from: classes2.dex */
public class b implements com.baidu.platform.comapi.walknavi.c.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBEngineInitListener f6747a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f6748b;

    public b(a aVar, IBEngineInitListener iBEngineInitListener) {
        this.f6748b = aVar;
        this.f6747a = iBEngineInitListener;
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void a() {
        this.f6747a.engineInitSuccess();
    }

    @Override // com.baidu.platform.comapi.walknavi.c.a
    public void b() {
        this.f6747a.engineInitFail();
    }
}
