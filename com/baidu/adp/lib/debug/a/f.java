package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f389a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f389a.a()) {
            gVar = this.f389a.f388a;
            gVar.invalidate();
            gVar2 = this.f389a.f388a;
            gVar2.post(this);
        }
    }
}
