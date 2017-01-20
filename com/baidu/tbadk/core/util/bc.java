package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ ba abo;
    private final /* synthetic */ ba.a abp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar, ba.a aVar) {
        this.abo = baVar;
        this.abp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abo.b(this.abp);
    }
}
