package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* loaded from: classes2.dex */
public class b extends a.AbstractRunnableC0099a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f8048a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f8049b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f8050c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.f8050c = aVar;
        this.f8048a = eVar;
        this.f8049b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0099a
    public void a() {
        int i2;
        int i3;
        c cVar = new c("GET", this.f8048a);
        i2 = this.f8050c.f8045a;
        cVar.b(i2);
        i3 = this.f8050c.f8046b;
        cVar.a(i3);
        cVar.a(this.f8049b);
    }
}
