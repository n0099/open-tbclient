package com.baidu.location.c;

import com.baidu.location.c.b;
/* loaded from: classes3.dex */
class c implements Runnable {
    final /* synthetic */ b.a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.this.k();
        } catch (Exception e) {
        }
    }
}
