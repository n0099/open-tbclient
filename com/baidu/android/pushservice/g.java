package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f716a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.f716a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f716a.f();
    }
}
