package com.baidu.adp.lib.network.willdelete;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g {
    private final /* synthetic */ AtomicInteger wg;
    private final /* synthetic */ String wh;
    private final /* synthetic */ AtomicLong wi;
    private final /* synthetic */ AtomicInteger wj;
    private final /* synthetic */ File wk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtomicInteger atomicInteger, String str, AtomicLong atomicLong, AtomicInteger atomicInteger2, File file) {
        this.wg = atomicInteger;
        this.wh = str;
        this.wi = atomicLong;
        this.wj = atomicInteger2;
        this.wk = file;
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void f(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.wg.incrementAndGet();
            return;
        }
        this.wg.set(0);
        h.a(this.wh, this.wi.longValue(), bArr, i, i2);
        this.wi.addAndGet(i2);
        this.wj.addAndGet(i2);
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void A(boolean z) {
        if (!z) {
            this.wk.delete();
            this.wi.set(0L);
        }
    }
}
