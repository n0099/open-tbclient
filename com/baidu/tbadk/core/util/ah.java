package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ af aaO;
    private final /* synthetic */ String aaP;
    private final /* synthetic */ int aaQ;
    private final /* synthetic */ String aaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, String str, int i, String str2) {
        this.aaO = afVar;
        this.aaP = str;
        this.aaQ = i;
        this.aaR = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File ux;
        boolean c;
        boolean cs;
        ux = this.aaO.ux();
        c = this.aaO.c(ux, this.aaP);
        if (c) {
            this.aaO.s(ux);
            cs = this.aaO.cs(this.aaQ);
            if (cs) {
                this.aaO.uv();
                return;
            }
        }
        this.aaO.uz();
        this.aaO.d(this.aaR, this.aaP, this.aaQ);
    }
}
