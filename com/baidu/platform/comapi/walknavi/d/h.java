package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* loaded from: classes2.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f9592a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f9593b;

    public h(g gVar, c cVar) {
        this.f9593b = gVar;
        this.f9592a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i) {
        g.a aVar;
        g.a aVar2;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onProgress = " + i);
        if (i == 100) {
            this.f9593b.n = false;
            g.b bVar = this.f9593b.f9581b;
            bVar.f9590c = 0;
            bVar.f9589b = "";
        }
        aVar = this.f9593b.o;
        if (aVar != null) {
            g gVar = this.f9593b;
            gVar.f9581b.f9590c = i;
            aVar2 = gVar.o;
            aVar2.a(this.f9593b.f9581b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f2) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f9592a);
        this.f9593b.n = false;
        g.b bVar = this.f9593b.f9581b;
        bVar.f9590c = 0;
        bVar.f9589b = "";
        c cVar = this.f9592a;
        if (cVar != null) {
            cVar.a(i, str);
        }
    }
}
