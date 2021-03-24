package com.baidu.platform.comapi.walknavi;

import com.baidu.platform.comapi.walknavi.g.a;
/* loaded from: classes2.dex */
public class f implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f10043a;

    public f(b bVar) {
        this.f10043a = bVar;
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
        this.f10043a.s();
    }
}
