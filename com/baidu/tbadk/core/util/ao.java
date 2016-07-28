package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ am Yp;
    private final /* synthetic */ String Yq;
    private final /* synthetic */ int Yr;
    private final /* synthetic */ String Ys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar, String str, int i, String str2) {
        this.Yp = amVar;
        this.Yq = str;
        this.Yr = i;
        this.Ys = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File tQ;
        boolean c;
        boolean cw;
        tQ = this.Yp.tQ();
        c = this.Yp.c(tQ, this.Yq);
        if (c) {
            this.Yp.q(tQ);
            cw = this.Yp.cw(this.Yr);
            if (cw) {
                this.Yp.tO();
                return;
            }
        }
        this.Yp.tS();
        this.Yp.c(this.Ys, this.Yq, this.Yr);
    }
}
