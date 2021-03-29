package com.baidu.mobads.utils;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f8543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f8544b;

    public k(h hVar, Runnable runnable) {
        this.f8544b = hVar;
        this.f8543a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8543a.run();
    }
}
