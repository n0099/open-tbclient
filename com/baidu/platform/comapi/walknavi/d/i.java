package com.baidu.platform.comapi.walknavi.d;
/* loaded from: classes2.dex */
public class i implements com.baidu.platform.comapi.walknavi.d.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f10036a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f10037b;

    public i(g gVar, c cVar) {
        this.f10037b = gVar;
        this.f10036a = cVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(boolean z, float f2) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa MainActivity isUpdate=" + z + ", size=" + f2);
        this.f10036a.a(z, f2);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i) {
        c cVar = this.f10036a;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.a
    public void a(int i, String str) {
        c cVar = this.f10036a;
        if (cVar != null) {
            cVar.a(i, str);
        }
    }
}
