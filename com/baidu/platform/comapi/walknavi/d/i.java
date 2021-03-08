package com.baidu.platform.comapi.walknavi.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2947a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, c cVar) {
        this.b = gVar;
        this.f2947a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa MainActivity isUpdate=" + z + ", size=" + f);
        this.f2947a.a(z, f);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i) {
        if (this.f2947a != null) {
            this.f2947a.a(i);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        if (this.f2947a != null) {
            this.f2947a.a(i, str);
        }
    }
}
