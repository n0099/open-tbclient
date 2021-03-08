package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f2464a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2464a.h != null) {
            this.f2464a.h.pause();
        }
    }
}
