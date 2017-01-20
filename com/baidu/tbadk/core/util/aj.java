package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ ah aas;
    private final /* synthetic */ String aat;
    private final /* synthetic */ int aau;
    private final /* synthetic */ String aav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar, String str, int i, String str2) {
        this.aas = ahVar;
        this.aat = str;
        this.aau = i;
        this.aav = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uT;
        boolean c;
        boolean cL;
        uT = this.aas.uT();
        c = this.aas.c(uT, this.aat);
        if (c) {
            this.aas.q(uT);
            cL = this.aas.cL(this.aau);
            if (cL) {
                this.aas.uR();
                return;
            }
        }
        this.aas.uV();
        this.aas.c(this.aav, this.aat, this.aau);
    }
}
