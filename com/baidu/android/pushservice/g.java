package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.f710a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f710a.f();
    }
}
