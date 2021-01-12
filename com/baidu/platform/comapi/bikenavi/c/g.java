package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g implements a.InterfaceC0285a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.f4156a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0285a
    public void a() {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        aVar = this.f4156a.v;
        if (aVar != null) {
            aVar2 = this.f4156a.v;
            aVar2.onFinish();
            aVar3 = this.f4156a.v;
            aVar3.cancel();
            return;
        }
        this.f4156a.q();
    }
}
