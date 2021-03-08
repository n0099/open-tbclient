package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g implements a.InterfaceC0295a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.f2879a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0295a
    public void a() {
        b.a aVar;
        b.a aVar2;
        b.a aVar3;
        aVar = this.f2879a.v;
        if (aVar != null) {
            aVar2 = this.f2879a.v;
            aVar2.onFinish();
            aVar3 = this.f2879a.v;
            aVar3.cancel();
            return;
        }
        this.f2879a.q();
    }
}
