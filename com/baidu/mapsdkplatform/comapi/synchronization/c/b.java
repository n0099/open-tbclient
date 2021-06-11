package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* loaded from: classes2.dex */
public class b extends a.AbstractRunnableC0101a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f7788a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7789b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f7790c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.f7790c = aVar;
        this.f7788a = eVar;
        this.f7789b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0101a
    public void a() {
        int i2;
        int i3;
        c cVar = new c("GET", this.f7788a);
        i2 = this.f7790c.f7785a;
        cVar.b(i2);
        i3 = this.f7790c.f7786b;
        cVar.a(i3);
        cVar.a(this.f7789b);
    }
}
