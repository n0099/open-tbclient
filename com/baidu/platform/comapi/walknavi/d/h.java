package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* loaded from: classes2.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10034a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f10035b;

    public h(g gVar, c cVar) {
        this.f10035b = gVar;
        this.f10034a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i) {
        g.a aVar;
        g.a aVar2;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onProgress = " + i);
        if (i == 100) {
            this.f10035b.n = false;
            g.b bVar = this.f10035b.f10023b;
            bVar.f10032c = 0;
            bVar.f10031b = "";
        }
        aVar = this.f10035b.o;
        if (aVar != null) {
            g gVar = this.f10035b;
            gVar.f10023b.f10032c = i;
            aVar2 = gVar.o;
            aVar2.a(this.f10035b.f10023b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f2) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f10034a);
        this.f10035b.n = false;
        g.b bVar = this.f10035b.f10023b;
        bVar.f10032c = 0;
        bVar.f10031b = "";
        c cVar = this.f10034a;
        if (cVar != null) {
            cVar.a(i, str);
        }
    }
}
