package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ bb agT;
    private final /* synthetic */ bb.a agU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, bb.a aVar) {
        this.agT = bbVar;
        this.agU = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agT.b(this.agU);
    }
}
