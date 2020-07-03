package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class g implements a.InterfaceC0233a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0233a
    public void a() {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        aVar = this.a.v;
        if (aVar != null) {
            aVar2 = this.a.v;
            aVar2.onFinish();
            aVar3 = this.a.v;
            aVar3.cancel();
            return;
        }
        this.a.q();
    }
}
