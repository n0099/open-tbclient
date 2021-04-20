package com.baidu.platform.comapi.walknavi.d.a;

import com.baidu.platform.comapi.walknavi.d.a.b;
import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* loaded from: classes2.dex */
public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9518a;

    public c(b bVar) {
        this.f9518a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.b.a
    public void a(boolean z, boolean z2) {
        b.a aVar;
        this.f9518a.k = z2;
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("download so finished");
        if (z) {
            this.f9518a.f();
            return;
        }
        aVar = this.f9518a.f9509g;
        aVar.b("download so failed");
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.b.a
    public void a(int i) {
        b.a aVar;
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("so progress: " + i);
        aVar = this.f9518a.f9509g;
        aVar.a(i / 2);
    }
}
