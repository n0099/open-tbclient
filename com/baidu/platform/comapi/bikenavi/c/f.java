package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f implements a.InterfaceC0089a {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0089a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.a.v;
        if (aVar != null) {
            aVar2 = this.a.v;
            aVar2.cancel();
        }
    }
}
