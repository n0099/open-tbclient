package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ ak abP;
    private final /* synthetic */ String abQ;
    private final /* synthetic */ String abT;
    private final /* synthetic */ int abU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar, String str, String str2, int i) {
        this.abP = akVar;
        this.abT = str;
        this.abQ = str2;
        this.abU = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abP.c(this.abT, this.abQ, this.abU);
    }
}
