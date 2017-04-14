package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ai afW;
    private final /* synthetic */ String afX;
    private final /* synthetic */ int afY;
    private final /* synthetic */ String afZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, String str, int i, String str2) {
        this.afW = aiVar;
        this.afX = str;
        this.afY = i;
        this.afZ = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vN;
        boolean d;
        boolean cK;
        vN = this.afW.vN();
        d = this.afW.d(vN, this.afX);
        if (d) {
            this.afW.r(vN);
            cK = this.afW.cK(this.afY);
            if (cK) {
                this.afW.vL();
                return;
            }
        }
        this.afW.vP();
        this.afW.c(this.afZ, this.afX, this.afY);
    }
}
