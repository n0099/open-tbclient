package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* loaded from: classes2.dex */
public class b extends a.AbstractRunnableC0100a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f7733a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f7735c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.f7735c = aVar;
        this.f7733a = eVar;
        this.f7734b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0100a
    public void a() {
        int i;
        int i2;
        c cVar = new c("GET", this.f7733a);
        i = this.f7735c.f7730a;
        cVar.b(i);
        i2 = this.f7735c.f7731b;
        cVar.a(i2);
        cVar.a(this.f7734b);
    }
}
