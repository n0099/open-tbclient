package com.baidu.adp.lib.network.willdelete;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g {
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

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.a.incrementAndGet();
            return;
        }
        this.a.set(0);
        h.a(this.b, this.c.longValue(), bArr, i, i2);
        this.c.addAndGet(i2);
        this.d.addAndGet(i2);
    }
}
