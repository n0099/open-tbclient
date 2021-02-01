package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends a.AbstractRunnableC0252a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f3094a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3095b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.c = aVar;
        this.f3094a = eVar;
        this.f3095b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0252a
    public void a() {
        int i;
        int i2;
        c cVar = new c("GET", this.f3094a);
        i = this.c.f3092a;
        cVar.b(i);
        i2 = this.c.f3093b;
        cVar.a(i2);
        cVar.a(this.f3095b);
    }
}
