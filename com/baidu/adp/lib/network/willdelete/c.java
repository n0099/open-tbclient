package com.baidu.adp.lib.network.willdelete;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g {
    private final /* synthetic */ AtomicInteger kO;
    private final /* synthetic */ String kP;
    private final /* synthetic */ AtomicLong kQ;
    private final /* synthetic */ AtomicInteger kR;
    private final /* synthetic */ File kS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtomicInteger atomicInteger, String str, AtomicLong atomicLong, AtomicInteger atomicInteger2, File file) {
        this.kO = atomicInteger;
        this.kP = str;
        this.kQ = atomicLong;
        this.kR = atomicInteger2;
        this.kS = file;
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void d(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.kO.incrementAndGet();
            return;
        }
        this.kO.set(0);
        h.a(this.kP, this.kQ.longValue(), bArr, i, i2);
        this.kQ.addAndGet(i2);
        this.kR.addAndGet(i2);
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void u(boolean z) {
        if (!z) {
            this.kS.delete();
            this.kQ.set(0L);
        }
    }
}
