package com.baidu.adp.lib.network.willdelete;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements g {
    private final /* synthetic */ AtomicInteger kS;
    private final /* synthetic */ String kT;
    private final /* synthetic */ AtomicLong kU;
    private final /* synthetic */ AtomicInteger kV;
    private final /* synthetic */ File kW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtomicInteger atomicInteger, String str, AtomicLong atomicLong, AtomicInteger atomicInteger2, File file) {
        this.kS = atomicInteger;
        this.kT = str;
        this.kU = atomicLong;
        this.kV = atomicInteger2;
        this.kW = file;
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void f(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.kS.incrementAndGet();
            return;
        }
        this.kS.set(0);
        h.a(this.kT, this.kU.longValue(), bArr, i, i2);
        this.kU.addAndGet(i2);
        this.kV.addAndGet(i2);
    }

    @Override // com.baidu.adp.lib.network.willdelete.g
    public void A(boolean z) {
        if (!z) {
            this.kW.delete();
            this.kU.set(0L);
        }
    }
}
