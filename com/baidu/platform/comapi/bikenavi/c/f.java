package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements a.InterfaceC0289a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f4158a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0289a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.f4158a.v;
        if (aVar != null) {
            aVar2 = this.f4158a.v;
            aVar2.cancel();
        }
    }
}
