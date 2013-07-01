package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.f312a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f312a.d();
    }
}
