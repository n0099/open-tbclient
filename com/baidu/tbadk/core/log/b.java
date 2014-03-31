package com.baidu.tbadk.core.log;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 60) {
                atomicBoolean2 = this.a.a;
                if (!atomicBoolean2.get()) {
                    break;
                }
                try {
                    synchronized (this) {
                        wait(3000L);
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.a("BdLogger", "write error ", e);
                }
                i = i2 + 1;
            } else {
                break;
            }
        }
        atomicBoolean = this.a.a;
        if (!atomicBoolean.get()) {
            this.a.a(true);
        }
    }
}
