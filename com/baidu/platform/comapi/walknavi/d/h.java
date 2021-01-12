package com.baidu.platform.comapi.walknavi.d;

import com.baidu.platform.comapi.walknavi.d.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class h implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4257a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f4258b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, c cVar) {
        this.f4258b = gVar;
        this.f4257a = cVar;
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
            this.f4258b.n = false;
            this.f4258b.f4254b.c = 0;
            this.f4258b.f4254b.f4256b = "";
        }
        aVar = this.f4258b.o;
        if (aVar != null) {
            this.f4258b.f4254b.c = i;
            aVar2 = this.f4258b.o;
            aVar2.a(this.f4258b.f4254b);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.a("NpcSDKManagerImp", "download onResponse = " + this.f4257a);
        this.f4258b.n = false;
        this.f4258b.f4254b.c = 0;
        this.f4258b.f4254b.f4256b = "";
        if (this.f4257a != null) {
            this.f4257a.a(i, str);
        }
    }
}
