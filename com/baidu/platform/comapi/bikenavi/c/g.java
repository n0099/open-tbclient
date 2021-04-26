package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class g implements a.InterfaceC0127a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9755a;

    public g(b bVar) {
        this.f9755a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0127a
    public void a() {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        aVar = this.f9755a.v;
        if (aVar != null) {
            aVar2 = this.f9755a.v;
            aVar2.onFinish();
            aVar3 = this.f9755a.v;
            aVar3.cancel();
            return;
        }
        this.f9755a.q();
    }
}
