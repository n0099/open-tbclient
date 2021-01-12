package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.platform.comapi.walknavi.d.a.d.a.c;
import com.baidu.platform.comapi.walknavi.d.a.d.b;
import com.baidu.platform.comapi.walknavi.d.a.g.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d implements c.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.C0281b f4223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b.C0281b c0281b) {
        this.f4223a = c0281b;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.a.c.a
    public boolean a() {
        return this.f4223a.b();
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.d.a.c.InterfaceC0280c
    public void a(long j, long j2) {
        j.a(new e(this, j, j2));
    }
}
