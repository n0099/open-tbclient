package com.baidu.platform.comapi.walknavi.d.a;

import com.baidu.platform.comapi.walknavi.d.a.b;
import com.baidu.platform.comapi.walknavi.d.a.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class c implements b.a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.b.a
    public void a(boolean z, boolean z2) {
        b.a aVar;
        this.a.k = z2;
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("download so finished");
        if (z) {
            this.a.f();
            return;
        }
        aVar = this.a.g;
        aVar.b("download so failed");
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.b.a
    public void a(int i) {
        b.a aVar;
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("so progress: " + i);
        aVar = this.a.g;
        aVar.a(i / 2);
    }
}
