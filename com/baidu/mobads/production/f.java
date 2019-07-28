package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.h.resume();
    }
}
