package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements a.InterfaceC0293a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.b f3014a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, a.b bVar2, int i) {
        this.c = bVar;
        this.f3014a = bVar2;
        this.b = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0293a
    public void a() {
        if (this.f3014a != null) {
            this.f3014a.b(this.b);
        }
    }
}
