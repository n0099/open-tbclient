package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f3460a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3460a.h != null) {
            this.f3460a.h.resume();
        }
    }
}
