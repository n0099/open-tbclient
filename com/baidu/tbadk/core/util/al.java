package com.baidu.tbadk.core.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ah aas;
    private final /* synthetic */ String aat;
    private final /* synthetic */ String aaw;
    private final /* synthetic */ int aax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ah ahVar, String str, String str2, int i) {
        this.aas = ahVar;
        this.aaw = str;
        this.aat = str2;
        this.aax = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aas.c(this.aaw, this.aat, this.aax);
    }
}
