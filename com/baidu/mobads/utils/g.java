package com.baidu.mobads.utils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f3533a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f3534b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, Runnable runnable) {
        this.f3534b = eVar;
        this.f3533a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3533a.run();
    }
}
