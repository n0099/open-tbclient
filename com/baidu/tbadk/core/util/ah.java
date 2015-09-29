package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ af aaI;
    private final /* synthetic */ String aaJ;
    private final /* synthetic */ int aaK;
    private final /* synthetic */ String aaL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, String str, int i, String str2) {
        this.aaI = afVar;
        this.aaJ = str;
        this.aaK = i;
        this.aaL = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File ux;
        boolean c;
        boolean cs;
        ux = this.aaI.ux();
        c = this.aaI.c(ux, this.aaJ);
        if (c) {
            this.aaI.r(ux);
            cs = this.aaI.cs(this.aaK);
            if (cs) {
                this.aaI.uv();
                return;
            }
        }
        this.aaI.uz();
        this.aaI.d(this.aaL, this.aaJ, this.aaK);
    }
}
