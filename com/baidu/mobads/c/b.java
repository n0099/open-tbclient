package com.baidu.mobads.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2324a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new c(this)).start();
    }
}
