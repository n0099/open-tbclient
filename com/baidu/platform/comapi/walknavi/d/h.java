package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4474a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f4475b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, c cVar) {
        this.f4475b = gVar;
        this.f4474a = cVar;
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
            this.f4475b.n = false;
            this.f4475b.f4471b.c = 0;
            this.f4475b.f4471b.f4473b = "";
        }
        aVar = this.f4475b.o;
        if (aVar != null) {
            this.f4475b.f4471b.c = i;
            aVar2 = this.f4475b.o;
            aVar2.a(this.f4475b.f4471b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f4474a);
        this.f4475b.n = false;
        this.f4475b.f4471b.c = 0;
        this.f4475b.f4471b.f4473b = "";
        if (this.f4474a != null) {
            this.f4474a.a(i, str);
        }
    }
}
