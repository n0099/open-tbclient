package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ah aas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.aas = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aas.uR();
    }
}
