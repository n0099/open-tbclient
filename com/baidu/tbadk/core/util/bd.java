package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ bb agm;
    private final /* synthetic */ bb.a agn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, bb.a aVar) {
        this.agm = bbVar;
        this.agn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agm.b(this.agn);
    }
}
