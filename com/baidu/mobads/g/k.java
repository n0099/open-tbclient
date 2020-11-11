package com.baidu.mobads.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2340a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, boolean z) {
        this.b = gVar;
        this.f2340a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new l(this)).start();
    }
}
