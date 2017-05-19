package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ai afp;
    private final /* synthetic */ String afq;
    private final /* synthetic */ int afr;
    private final /* synthetic */ String afs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, String str, int i, String str2) {
        this.afp = aiVar;
        this.afq = str;
        this.afr = i;
        this.afs = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File va;
        boolean d;
        boolean cH;
        va = this.afp.va();
        d = this.afp.d(va, this.afq);
        if (d) {
            this.afp.r(va);
            cH = this.afp.cH(this.afr);
            if (cH) {
                this.afp.uY();
                return;
            }
        }
        this.afp.vc();
        this.afp.c(this.afs, this.afq, this.afr);
    }
}
