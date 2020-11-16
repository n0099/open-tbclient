package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements a.InterfaceC0291a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.f2836a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0291a
    public void a() {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        aVar = this.f2836a.v;
        if (aVar != null) {
            aVar2 = this.f2836a.v;
            aVar2.onFinish();
            aVar3 = this.f2836a.v;
            aVar3.cancel();
            return;
        }
        this.f2836a.q();
    }
}
