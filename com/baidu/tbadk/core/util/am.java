package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ak acf;
    private final /* synthetic */ String acg;
    private final /* synthetic */ int ach;
    private final /* synthetic */ String aci;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar, String str, int i, String str2) {
        this.acf = akVar;
        this.acg = str;
        this.ach = i;
        this.aci = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uN;
        boolean c;
        boolean ct;
        uN = this.acf.uN();
        c = this.acf.c(uN, this.acg);
        if (c) {
            this.acf.s(uN);
            ct = this.acf.ct(this.ach);
            if (ct) {
                this.acf.uL();
                return;
            }
        }
        this.acf.uP();
        this.acf.d(this.aci, this.acg, this.ach);
    }
}
