package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ ak acf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar) {
        this.acf = akVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acf.uL();
    }
}
