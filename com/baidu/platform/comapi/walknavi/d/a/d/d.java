package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.a.c;
import com.baidu.platform.comapi.walknavi.d.a.d.b;
import com.baidu.platform.comapi.walknavi.d.a.g.j;
/* loaded from: classes4.dex */
class d implements c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.C0285b f4226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b.C0285b c0285b) {
        this.f4226a = c0285b;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.a.c.a
    public boolean a() {
        return this.f4226a.b();
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.a.c.InterfaceC0284c
    public void a(long j, long j2) {
        j.a(new e(this, j, j2));
    }
}
