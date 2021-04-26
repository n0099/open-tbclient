package com.baidu.platform.comapi.walknavi.d;
/* loaded from: classes2.dex */
public class i implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f9952a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f9953b;

    public i(g gVar, c cVar) {
        this.f9953b = gVar;
        this.f9952a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f2) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa MainActivity isUpdate=" + z + ", size=" + f2);
        this.f9952a.a(z, f2);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i2) {
        c cVar = this.f9952a;
        if (cVar != null) {
            cVar.a(i2);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i2, String str) {
        c cVar = this.f9952a;
        if (cVar != null) {
            cVar.a(i2, str);
        }
    }
}
