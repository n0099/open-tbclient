package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class h implements a.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.f3075a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.a.b
    public void a(int i) {
        if (i == 1) {
            if (b.a().T() instanceof com.baidu.platform.comapi.walknavi.g.a) {
                b.a().S().a(new i(this));
                return;
            }
            return;
        }
        this.f3075a.v();
    }

    @Override // com.baidu.platform.comapi.walknavi.g.a.b
    public void b(int i) {
        if (i == 3 || i == 1) {
            b.a().T().q();
        } else if (i == 2) {
            b.a().a(false);
            b.a().G().c(false);
        }
    }
}
