package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements Runnable {
    final /* synthetic */ bf acK;
    private final /* synthetic */ bf.a acL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar, bf.a aVar) {
        this.acK = bfVar;
        this.acL = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acK.b(this.acL);
    }
}
