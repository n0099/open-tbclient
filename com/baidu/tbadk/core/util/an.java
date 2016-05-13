package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ al Xo;
    private final /* synthetic */ String Xp;
    private final /* synthetic */ int Xq;
    private final /* synthetic */ String Xr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, String str, int i, String str2) {
        this.Xo = alVar;
        this.Xp = str;
        this.Xq = i;
        this.Xr = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File tS;
        boolean c;
        boolean cv;
        tS = this.Xo.tS();
        c = this.Xo.c(tS, this.Xp);
        if (c) {
            this.Xo.q(tS);
            cv = this.Xo.cv(this.Xq);
            if (cv) {
                this.Xo.tQ();
                return;
            }
        }
        this.Xo.tU();
        this.Xo.c(this.Xr, this.Xp, this.Xq);
    }
}
