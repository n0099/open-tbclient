package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {
    final /* synthetic */ c a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, c cVar) {
        this.b = gVar;
        this.a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i) {
        g.a aVar;
        g.a aVar2;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onProgress = " + i);
        if (i == 100) {
            this.b.n = false;
            this.b.b.c = 0;
            this.b.b.b = "";
        }
        aVar = this.b.o;
        if (aVar != null) {
            this.b.b.c = i;
            aVar2 = this.b.o;
            aVar2.a(this.b.b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.a);
        this.b.n = false;
        this.b.b.c = 0;
        this.b.b.b = "";
        if (this.a != null) {
            this.a.a(i, str);
        }
    }
}
