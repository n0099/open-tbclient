package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements a.InterfaceC0281a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.b f3012a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, a.b bVar2, int i) {
        this.c = bVar;
        this.f3012a = bVar2;
        this.b = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0281a
    public void a() {
        if (this.f3012a != null) {
            this.f3012a.b(this.b);
        }
    }
}
