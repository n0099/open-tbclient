package com.baidu.adp.lib.a;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar) {
        super(null);
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        AtomicBoolean atomicBoolean;
        Object d;
        atomicBoolean = this.a.k;
        atomicBoolean.set(true);
        d = this.a.d(this.a.a(this.b));
        return d;
    }
}
