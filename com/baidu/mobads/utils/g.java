package com.baidu.mobads.utils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f2441a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, Runnable runnable) {
        this.b = eVar;
        this.f2441a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2441a.run();
    }
}
