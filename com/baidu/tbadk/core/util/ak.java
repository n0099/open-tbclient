package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ai afg;
    private final /* synthetic */ String afh;
    private final /* synthetic */ int afi;
    private final /* synthetic */ String afj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar, String str, int i, String str2) {
        this.afg = aiVar;
        this.afh = str;
        this.afi = i;
        this.afj = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uX;
        boolean d;
        boolean cI;
        uX = this.afg.uX();
        d = this.afg.d(uX, this.afh);
        if (d) {
            this.afg.r(uX);
            cI = this.afg.cI(this.afi);
            if (cI) {
                this.afg.uV();
                return;
            }
        }
        this.afg.uZ();
        this.afg.c(this.afj, this.afh, this.afi);
    }
}
