package com.baidu.location.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class w extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1917a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.f1917a = sVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean g;
        g = this.f1917a.g();
        if (g) {
            this.f1917a.h();
        }
    }
}
