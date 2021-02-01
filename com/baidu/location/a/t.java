package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class t extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f2581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.f2581a = pVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.f2581a.i();
        if (i) {
            this.f2581a.j();
        }
    }
}
