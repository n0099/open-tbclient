package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ai afX;
    private final /* synthetic */ String afY;
    private final /* synthetic */ int afZ;
    private final /* synthetic */ String aga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, String str, int i, String str2) {
        this.afX = aiVar;
        this.afY = str;
        this.afZ = i;
        this.aga = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vN;
        boolean d;
        boolean cK;
        vN = this.afX.vN();
        d = this.afX.d(vN, this.afY);
        if (d) {
            this.afX.r(vN);
            cK = this.afX.cK(this.afZ);
            if (cK) {
                this.afX.vL();
                return;
            }
        }
        this.afX.vP();
        this.afX.c(this.aga, this.afY, this.afZ);
    }
}
