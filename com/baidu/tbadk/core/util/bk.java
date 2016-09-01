package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements Runnable {
    final /* synthetic */ bi abZ;
    private final /* synthetic */ bi.a aca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar, bi.a aVar) {
        this.abZ = biVar;
        this.aca = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abZ.b(this.aca);
    }
}
