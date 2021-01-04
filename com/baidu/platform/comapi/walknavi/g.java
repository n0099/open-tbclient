package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.walknavi.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class g implements a.InterfaceC0302a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.b f4494a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f4495b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, a.b bVar2, int i) {
        this.c = bVar;
        this.f4494a = bVar2;
        this.f4495b = i;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0302a
    public void a() {
        if (this.f4494a != null) {
            this.f4494a.b(this.f4495b);
        }
    }
}
