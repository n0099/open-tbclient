package com.baidu.mobads.utils;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f8542a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f8543b;

    public k(h hVar, Runnable runnable) {
        this.f8543b = hVar;
        this.f8542a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8542a.run();
    }
}
