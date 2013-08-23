package com.baidu.adp.lib.debug.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f397a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        if (this.f397a.a()) {
            gVar = this.f397a.f396a;
            gVar.invalidate();
            gVar2 = this.f397a.f396a;
            gVar2.post(this);
        }
    }
}
