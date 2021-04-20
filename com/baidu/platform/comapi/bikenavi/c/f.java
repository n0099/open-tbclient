package com.baidu.platform.comapi.bikenavi.c;

import com.baidu.platform.comapi.bikenavi.c.b;
import com.baidu.platform.comapi.walknavi.widget.a;
/* loaded from: classes2.dex */
public class f implements a.InterfaceC0127a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9402a;

    public f(b bVar) {
        this.f9402a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0127a
    public void a() {
        b.a aVar;
        b.a aVar2;
        aVar = this.f9402a.v;
        if (aVar != null) {
            aVar2 = this.f9402a.v;
            aVar2.cancel();
        }
    }
}
