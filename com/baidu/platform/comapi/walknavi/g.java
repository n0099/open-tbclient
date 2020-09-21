package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements a.InterfaceC0252a {
    final /* synthetic */ a.b a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, a.b bVar2, int i) {
        this.c = bVar;
        this.a = bVar2;
        this.b = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0252a
    public void a() {
        if (this.a != null) {
            this.a.b(this.b);
        }
    }
}
