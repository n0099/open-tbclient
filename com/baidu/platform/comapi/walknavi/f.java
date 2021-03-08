package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements a.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f2953a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.a.b
    public void a(int i) {
        if (i == 1) {
            if (b.a().Q() instanceof com.baidu.platform.comapi.walknavi.g.a) {
                b.a().P().a(new g(this));
                return;
            }
            return;
        }
        this.f2953a.s();
    }
}
