package com.baidu.location.b;
/* loaded from: classes2.dex */
public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f6565a;

    public p(o oVar) {
        this.f6565a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a2;
        if (!com.baidu.location.c.i.i()) {
            a2 = this.f6565a.a(com.baidu.location.f.getServiceContext());
            if (!a2) {
                return;
            }
        }
        this.f6565a.a(v.a().c());
    }
}
