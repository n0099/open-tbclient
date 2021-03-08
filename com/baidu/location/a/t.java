package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class t extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.f1936a = pVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.f1936a.i();
        if (i) {
            this.f1936a.j();
        }
    }
}
