package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ bb agc;
    private final /* synthetic */ bb.a agd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, bb.a aVar) {
        this.agc = bbVar;
        this.agd = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agc.b(this.agd);
    }
}
