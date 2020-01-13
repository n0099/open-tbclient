package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.h.pause();
    }
}
