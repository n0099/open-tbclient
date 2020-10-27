package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements a.InterfaceC0281a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2833a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f2833a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0281a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.f2833a.v;
        if (aVar != null) {
            aVar2 = this.f2833a.v;
            aVar2.cancel();
        }
    }
}
