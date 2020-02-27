package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b extends a.AbstractRunnableC0119a {
    final /* synthetic */ e a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.c = aVar;
        this.a = eVar;
        this.b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0119a
    public void a() {
        int i;
        int i2;
        c cVar = new c("GET", this.a);
        i = this.c.a;
        cVar.b(i);
        i2 = this.c.b;
        cVar.a(i2);
        cVar.a(this.b);
    }
}
