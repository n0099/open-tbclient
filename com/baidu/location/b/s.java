package com.baidu.location.b;
/* loaded from: classes2.dex */
public class s extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f6668a;

    public s(o oVar) {
        this.f6668a = oVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean g2;
        g2 = this.f6668a.g();
        if (g2) {
            this.f6668a.h();
        }
    }
}
