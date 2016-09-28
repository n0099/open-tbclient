package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements Runnable {
    final /* synthetic */ bh acm;
    private final /* synthetic */ bh.a acn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh bhVar, bh.a aVar) {
        this.acm = bhVar;
        this.acn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acm.b(this.acn);
    }
}
