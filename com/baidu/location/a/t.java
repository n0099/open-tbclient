package com.baidu.location.a;
/* loaded from: classes2.dex */
public class t extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f6582a;

    public t(p pVar) {
        this.f6582a = pVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.f6582a.i();
        if (i) {
            this.f6582a.j();
        }
    }
}
