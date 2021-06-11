package com.baidu.location.b;
/* loaded from: classes2.dex */
public class s extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f6611a;

    public s(o oVar) {
        this.f6611a = oVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean g2;
        g2 = this.f6611a.g();
        if (g2) {
            this.f6611a.h();
        }
    }
}
