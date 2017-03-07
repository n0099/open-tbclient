package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ bb agF;
    private final /* synthetic */ bb.a agG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, bb.a aVar) {
        this.agF = bbVar;
        this.agG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agF.b(this.agG);
    }
}
