package com.baidu.platform.comapi.walknavi.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4262a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f4263b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, c cVar) {
        this.f4263b = gVar;
        this.f4262a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa MainActivity isUpdate=" + z + ", size=" + f);
        this.f4262a.a(z, f);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i) {
        if (this.f4262a != null) {
            this.f4262a.a(i);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        if (this.f4262a != null) {
            this.f4262a.a(i, str);
        }
    }
}
