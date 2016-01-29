package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ aj acB;
    private final /* synthetic */ String acC;
    private final /* synthetic */ int acD;
    private final /* synthetic */ String acE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar, String str, int i, String str2) {
        this.acB = ajVar;
        this.acC = str;
        this.acD = i;
        this.acE = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vS;
        boolean c;
        boolean cK;
        vS = this.acB.vS();
        c = this.acB.c(vS, this.acC);
        if (c) {
            this.acB.s(vS);
            cK = this.acB.cK(this.acD);
            if (cK) {
                this.acB.vQ();
                return;
            }
        }
        this.acB.vU();
        this.acB.d(this.acE, this.acC, this.acD);
    }
}
