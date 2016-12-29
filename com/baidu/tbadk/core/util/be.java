package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements Runnable {
    final /* synthetic */ bc acd;
    private final /* synthetic */ bc.a ace;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bc bcVar, bc.a aVar) {
        this.acd = bcVar;
        this.ace = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acd.b(this.ace);
    }
}
