package com.baidu.mobads.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f3374a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f3375b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, boolean z) {
        this.f3375b = gVar;
        this.f3374a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new l(this)).start();
    }
}
