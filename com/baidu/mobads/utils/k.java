package com.baidu.mobads.utils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f2486a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, Runnable runnable) {
        this.b = hVar;
        this.f2486a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2486a.run();
    }
}
