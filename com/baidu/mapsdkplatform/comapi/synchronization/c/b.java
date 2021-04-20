package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* loaded from: classes2.dex */
public class b extends a.AbstractRunnableC0099a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f7768a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7769b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f7770c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.f7770c = aVar;
        this.f7768a = eVar;
        this.f7769b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0099a
    public void a() {
        int i;
        int i2;
        c cVar = new c("GET", this.f7768a);
        i = this.f7770c.f7765a;
        cVar.b(i);
        i2 = this.f7770c.f7766b;
        cVar.a(i2);
        cVar.a(this.f7769b);
    }
}
