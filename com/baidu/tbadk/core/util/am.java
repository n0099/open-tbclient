package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ak abB;
    private final /* synthetic */ String abC;
    private final /* synthetic */ int abD;
    private final /* synthetic */ String abE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar, String str, int i, String str2) {
        this.abB = akVar;
        this.abC = str;
        this.abD = i;
        this.abE = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vd;
        boolean c;
        boolean cA;
        vd = this.abB.vd();
        c = this.abB.c(vd, this.abC);
        if (c) {
            this.abB.s(vd);
            cA = this.abB.cA(this.abD);
            if (cA) {
                this.abB.vb();
                return;
            }
        }
        this.abB.vf();
        this.abB.d(this.abE, this.abC, this.abD);
    }
}
