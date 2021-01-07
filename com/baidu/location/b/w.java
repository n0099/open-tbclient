package com.baidu.location.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class w extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f2665a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.f2665a = sVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean g;
        g = this.f2665a.g();
        if (g) {
            this.f2665a.h();
        }
    }
}
