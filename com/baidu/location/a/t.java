package com.baidu.location.a;
/* loaded from: classes2.dex */
public class t extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f6843a;

    public t(p pVar) {
        this.f6843a = pVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i2;
        i2 = this.f6843a.i();
        if (i2) {
            this.f6843a.j();
        }
    }
}
