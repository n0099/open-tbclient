package com.baidu.mobads.openad.d;

import com.baidu.mobads.utils.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.f != null && this.a.d.getAndSet(false)) {
                this.a.f.disconnect();
                this.a.f = null;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
    }
}
