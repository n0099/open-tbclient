package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f399a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f399a.a()) {
            gVar = this.f399a.f398a;
            gVar.invalidate();
            gVar2 = this.f399a.f398a;
            gVar2.post(this);
        }
    }
}
