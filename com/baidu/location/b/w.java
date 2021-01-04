package com.baidu.location.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class w extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f2664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.f2664a = sVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean g;
        g = this.f2664a.g();
        if (g) {
            this.f2664a.h();
        }
    }
}
