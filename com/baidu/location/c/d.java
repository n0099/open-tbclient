package com.baidu.location.c;

import com.baidu.location.c.b;
/* loaded from: classes20.dex */
class d implements Runnable {
    final /* synthetic */ b.C0207b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b.C0207b c0207b) {
        this.a = c0207b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.this.k();
        } catch (Exception e) {
        }
    }
}
