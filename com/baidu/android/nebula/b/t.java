package com.baidu.android.nebula.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(c cVar) {
        this.f537a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new b(this)).start();
    }
}
