package com.baidu.platform.comapi.walknavi.d.a;

import com.baidu.platform.comapi.walknavi.d.a.b;
import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2971a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.b.a
    public void a(boolean z, boolean z2) {
        b.a aVar;
        this.f2971a.k = z2;
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("download so finished");
        if (z) {
            this.f2971a.f();
            return;
        }
        aVar = this.f2971a.g;
        aVar.b("download so failed");
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.b.a
    public void a(int i) {
        b.a aVar;
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("so progress: " + i);
        aVar = this.f2971a.g;
        aVar.a(i / 2);
    }
}
