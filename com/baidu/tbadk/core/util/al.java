package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ aj abg;
    private final /* synthetic */ String abh;
    private final /* synthetic */ int abi;
    private final /* synthetic */ String abj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar, String str, int i, String str2) {
        this.abg = ajVar;
        this.abh = str;
        this.abi = i;
        this.abj = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uZ;
        boolean c;
        boolean cM;
        uZ = this.abg.uZ();
        c = this.abg.c(uZ, this.abh);
        if (c) {
            this.abg.q(uZ);
            cM = this.abg.cM(this.abi);
            if (cM) {
                this.abg.uX();
                return;
            }
        }
        this.abg.vb();
        this.abg.c(this.abj, this.abh, this.abi);
    }
}
