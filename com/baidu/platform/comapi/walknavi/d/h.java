package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4473a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f4474b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, c cVar) {
        this.f4474b = gVar;
        this.f4473a = cVar;
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
            this.f4474b.n = false;
            this.f4474b.f4470b.c = 0;
            this.f4474b.f4470b.f4472b = "";
        }
        aVar = this.f4474b.o;
        if (aVar != null) {
            this.f4474b.f4470b.c = i;
            aVar2 = this.f4474b.o;
            aVar2.a(this.f4474b.f4470b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f4473a);
        this.f4474b.n = false;
        this.f4474b.f4470b.c = 0;
        this.f4474b.f4470b.f4472b = "";
        if (this.f4473a != null) {
            this.f4473a.a(i, str);
        }
    }
}
