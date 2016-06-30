package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {
    final /* synthetic */ bi YB;
    private final /* synthetic */ bi.a YC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar, bi.a aVar) {
        this.YB = biVar;
        this.YC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.YB.b(this.YC);
    }
}
