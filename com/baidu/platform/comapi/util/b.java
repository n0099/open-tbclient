package com.baidu.platform.comapi.util;

import com.baidu.platform.comapi.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class b implements Runnable {
    final /* synthetic */ a.C0246a a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, a.C0246a c0246a, Object obj) {
        this.c = aVar;
        this.a = c0246a;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.a, this.b);
    }
}
