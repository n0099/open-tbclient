package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* loaded from: classes2.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f9950a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f9951b;

    public h(g gVar, c cVar) {
        this.f9951b = gVar;
        this.f9950a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i2) {
        g.a aVar;
        g.a aVar2;
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onProgress = " + i2);
        if (i2 == 100) {
            this.f9951b.n = false;
            g.b bVar = this.f9951b.f9938b;
            bVar.f9948c = 0;
            bVar.f9947b = "";
        }
        aVar = this.f9951b.o;
        if (aVar != null) {
            g gVar = this.f9951b;
            gVar.f9938b.f9948c = i2;
            aVar2 = gVar.o;
            aVar2.a(this.f9951b.f9938b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f2) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i2, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f9950a);
        this.f9951b.n = false;
        g.b bVar = this.f9951b.f9938b;
        bVar.f9948c = 0;
        bVar.f9947b = "";
        c cVar = this.f9950a;
        if (cVar != null) {
            cVar.a(i2, str);
        }
    }
}
