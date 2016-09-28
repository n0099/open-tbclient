package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ am abq;
    private final /* synthetic */ String abr;
    private final /* synthetic */ int abt;
    private final /* synthetic */ String abu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar, String str, int i, String str2) {
        this.abq = amVar;
        this.abr = str;
        this.abt = i;
        this.abu = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vl;
        boolean c;
        boolean cJ;
        vl = this.abq.vl();
        c = this.abq.c(vl, this.abr);
        if (c) {
            this.abq.q(vl);
            cJ = this.abq.cJ(this.abt);
            if (cJ) {
                this.abq.vj();
                return;
            }
        }
        this.abq.vn();
        this.abq.c(this.abu, this.abr, this.abt);
    }
}
