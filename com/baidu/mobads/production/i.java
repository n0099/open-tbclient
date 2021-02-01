package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3459a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f3459a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3459a.h != null) {
            this.f3459a.h.pause();
        }
    }
}
