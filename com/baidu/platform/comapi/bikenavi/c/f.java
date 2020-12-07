package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class f implements a.InterfaceC0302a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f2837a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0302a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.f2837a.v;
        if (aVar != null) {
            aVar2 = this.f2837a.v;
            aVar2.cancel();
        }
    }
}
