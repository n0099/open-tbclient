package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.baidu.mapsdkplatform.comapi.synchronization.c.a;
/* loaded from: classes2.dex */
public class b extends a.AbstractRunnableC0099a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f7845a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7846b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f7847c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, e eVar, String str) {
        super(null);
        this.f7847c = aVar;
        this.f7845a = eVar;
        this.f7846b = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.a.AbstractRunnableC0099a
    public void a() {
        int i2;
        int i3;
        c cVar = new c("GET", this.f7845a);
        i2 = this.f7847c.f7842a;
        cVar.b(i2);
        i3 = this.f7847c.f7843b;
        cVar.a(i3);
        cVar.a(this.f7846b);
    }
}
