package com.baidu.location.a;
/* loaded from: classes2.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f6840a;

    public q(p pVar) {
        this.f6840a = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a2;
        if (!com.baidu.location.b.i.i()) {
            a2 = this.f6840a.a(com.baidu.location.f.getServiceContext());
            if (!a2) {
                return;
            }
        }
        this.f6840a.d();
    }
}
