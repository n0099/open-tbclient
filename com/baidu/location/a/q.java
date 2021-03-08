package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1933a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.f1933a = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a2;
        if (!com.baidu.location.b.i.i()) {
            a2 = this.f1933a.a(com.baidu.location.f.getServiceContext());
            if (!a2) {
                return;
            }
        }
        this.f1933a.d();
    }
}
