package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f implements a.InterfaceC0285a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f4155a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0285a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.f4155a.v;
        if (aVar != null) {
            aVar2 = this.f4155a.v;
            aVar2.cancel();
        }
    }
}
