package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {
    final /* synthetic */ bi Zk;
    private final /* synthetic */ bi.a Zl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar, bi.a aVar) {
        this.Zk = biVar;
        this.Zl = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Zk.b(this.Zl);
    }
}
