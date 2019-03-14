package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f implements a.b {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.a = bVar;
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
        this.a.s();
    }
}
