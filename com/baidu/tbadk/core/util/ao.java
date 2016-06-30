package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ am XG;
    private final /* synthetic */ String XH;
    private final /* synthetic */ int XI;
    private final /* synthetic */ String XJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar, String str, int i, String str2) {
        this.XG = amVar;
        this.XH = str;
        this.XI = i;
        this.XJ = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File tR;
        boolean c;
        boolean cw;
        tR = this.XG.tR();
        c = this.XG.c(tR, this.XH);
        if (c) {
            this.XG.q(tR);
            cw = this.XG.cw(this.XI);
            if (cw) {
                this.XG.tP();
                return;
            }
        }
        this.XG.tT();
        this.XG.c(this.XJ, this.XH, this.XI);
    }
}
