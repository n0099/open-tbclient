package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b extends a.AbstractRunnableC0251a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f3096a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3097b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.c = aVar;
        this.f3096a = eVar;
        this.f3097b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0251a
    public void a() {
        int i;
        int i2;
        c cVar = new c("GET", this.f3096a);
        i = this.c.f3094a;
        cVar.b(i);
        i2 = this.c.f3095b;
        cVar.a(i2);
        cVar.a(this.f3097b);
    }
}
