package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4260a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f4261b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, c cVar) {
        this.f4261b = gVar;
        this.f4260a = cVar;
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
            this.f4261b.n = false;
            this.f4261b.f4257b.c = 0;
            this.f4261b.f4257b.f4259b = "";
        }
        aVar = this.f4261b.o;
        if (aVar != null) {
            this.f4261b.f4257b.c = i;
            aVar2 = this.f4261b.o;
            aVar2.a(this.f4261b.f4257b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f4260a);
        this.f4261b.n = false;
        this.f4261b.f4257b.c = 0;
        this.f4261b.f4257b.f4259b = "";
        if (this.f4260a != null) {
            this.f4260a.a(i, str);
        }
    }
}
