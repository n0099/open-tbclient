package com.baidu.mobads.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f3375a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f3376b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, boolean z) {
        this.f3376b = gVar;
        this.f3375a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new l(this)).start();
    }
}
