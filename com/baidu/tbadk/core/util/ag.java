package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ ae aaO;
    private final /* synthetic */ String aaP;
    private final /* synthetic */ int aaQ;
    private final /* synthetic */ String aaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, String str, int i, String str2) {
        this.aaO = aeVar;
        this.aaP = str;
        this.aaQ = i;
        this.aaR = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uz;
        boolean c;
        boolean cq;
        uz = this.aaO.uz();
        c = this.aaO.c(uz, this.aaP);
        if (c) {
            this.aaO.s(uz);
            cq = this.aaO.cq(this.aaQ);
            if (cq) {
                this.aaO.ux();
                return;
            }
        }
        this.aaO.uB();
        this.aaO.d(this.aaR, this.aaP, this.aaQ);
    }
}
