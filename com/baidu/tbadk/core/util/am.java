package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ak abP;
    private final /* synthetic */ String abQ;
    private final /* synthetic */ int abR;
    private final /* synthetic */ String abS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar, String str, int i, String str2) {
        this.abP = akVar;
        this.abQ = str;
        this.abR = i;
        this.abS = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vp;
        boolean c;
        boolean cK;
        vp = this.abP.vp();
        c = this.abP.c(vp, this.abQ);
        if (c) {
            this.abP.q(vp);
            cK = this.abP.cK(this.abR);
            if (cK) {
                this.abP.vn();
                return;
            }
        }
        this.abP.vr();
        this.abP.c(this.abS, this.abQ, this.abR);
    }
}
