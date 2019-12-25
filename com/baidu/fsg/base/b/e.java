package com.baidu.fsg.base.b;

import com.baidu.fsg.base.b.a;
/* loaded from: classes3.dex */
class e implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ a.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.b bVar, Runnable runnable) {
        this.b = bVar;
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
        } finally {
            this.b.a();
        }
    }
}
