package com.baidu.mobads.utils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f3534a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f3535b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, Runnable runnable) {
        this.f3535b = eVar;
        this.f3534a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3534a.run();
    }
}
