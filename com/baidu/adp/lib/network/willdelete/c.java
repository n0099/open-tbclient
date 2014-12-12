package com.baidu.adp.lib.network.willdelete;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g {
    private final /* synthetic */ AtomicInteger kP;
    private final /* synthetic */ String kQ;
    private final /* synthetic */ AtomicLong kR;
    private final /* synthetic */ AtomicInteger kS;
    private final /* synthetic */ File kT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtomicInteger atomicInteger, String str, AtomicLong atomicLong, AtomicInteger atomicInteger2, File file) {
        this.kP = atomicInteger;
        this.kQ = str;
        this.kR = atomicLong;
        this.kS = atomicInteger2;
        this.kT = file;
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void f(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.kP.incrementAndGet();
            return;
        }
        this.kP.set(0);
        h.a(this.kQ, this.kR.longValue(), bArr, i, i2);
        this.kR.addAndGet(i2);
        this.kS.addAndGet(i2);
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void A(boolean z) {
        if (!z) {
            this.kT.delete();
            this.kR.set(0L);
        }
    }
}
