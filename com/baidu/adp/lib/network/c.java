package com.baidu.adp.lib.network;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
final class c implements g {
    private final /* synthetic */ AtomicInteger a;
    private final /* synthetic */ String b;
    private final /* synthetic */ AtomicLong c;
    private final /* synthetic */ AtomicInteger d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtomicInteger atomicInteger, String str, AtomicLong atomicLong, AtomicInteger atomicInteger2) {
        this.a = atomicInteger;
        this.b = str;
        this.c = atomicLong;
        this.d = atomicInteger2;
    }

    @Override // com.baidu.adp.lib.network.g
    public final void a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.a.incrementAndGet();
            return;
        }
        this.a.set(0);
        i.a(this.b, this.c.longValue(), bArr, 0, i2);
        this.c.addAndGet(i2);
        this.d.addAndGet(i2);
    }
}
