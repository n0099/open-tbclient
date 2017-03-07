package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ai afI;
    private final /* synthetic */ String afJ;
    private final /* synthetic */ int afK;
    private final /* synthetic */ String afL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, String str, int i, String str2) {
        this.afI = aiVar;
        this.afJ = str;
        this.afK = i;
        this.afL = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vq;
        boolean d;
        boolean cH;
        vq = this.afI.vq();
        d = this.afI.d(vq, this.afJ);
        if (d) {
            this.afI.q(vq);
            cH = this.afI.cH(this.afK);
            if (cH) {
                this.afI.vo();
                return;
            }
        }
        this.afI.vs();
        this.afI.c(this.afL, this.afJ, this.afK);
    }
}
