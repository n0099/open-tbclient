package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* loaded from: classes2.dex */
public class b extends a.AbstractRunnableC0100a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f7745a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7746b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f7747c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.f7747c = aVar;
        this.f7745a = eVar;
        this.f7746b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0100a
    public void a() {
        int i2;
        int i3;
        c cVar = new c("GET", this.f7745a);
        i2 = this.f7747c.f7742a;
        cVar.b(i2);
        i3 = this.f7747c.f7743b;
        cVar.a(i3);
        cVar.a(this.f7746b);
    }
}
