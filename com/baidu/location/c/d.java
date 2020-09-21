package com.baidu.location.c;

import com.baidu.location.c.b;
/* loaded from: classes3.dex */
class d implements Runnable {
    final /* synthetic */ b.C0206b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b.C0206b c0206b) {
        this.a = c0206b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.this.k();
        } catch (Exception e) {
        }
    }
}
