package com.baidu.android.nebula.localserver.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ BDLocationManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BDLocationManager bDLocationManager, long j) {
        this.b = bDLocationManager;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.location.e eVar;
        if (this.a > 0) {
            try {
                Thread.sleep(this.a);
            } catch (InterruptedException e) {
            }
        }
        this.b.h = true;
        this.b.j = System.currentTimeMillis();
        eVar = this.b.d;
        eVar.b();
    }
}
