package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ al abO;
    private final /* synthetic */ String abP;
    private final /* synthetic */ int abQ;
    private final /* synthetic */ String abR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, String str, int i, String str2) {
        this.abO = alVar;
        this.abP = str;
        this.abQ = i;
        this.abR = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File wl;
        boolean b;
        boolean cN;
        wl = this.abO.wl();
        b = this.abO.b(wl, this.abP);
        if (b) {
            this.abO.q(wl);
            cN = this.abO.cN(this.abQ);
            if (cN) {
                this.abO.wj();
                return;
            }
        }
        this.abO.wn();
        this.abO.c(this.abR, this.abP, this.abQ);
    }
}
