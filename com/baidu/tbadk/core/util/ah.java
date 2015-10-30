package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ af aaK;
    private final /* synthetic */ String aaL;
    private final /* synthetic */ int aaM;
    private final /* synthetic */ String aaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, String str, int i, String str2) {
        this.aaK = afVar;
        this.aaL = str;
        this.aaM = i;
        this.aaN = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uu;
        boolean c;
        boolean cs;
        uu = this.aaK.uu();
        c = this.aaK.c(uu, this.aaL);
        if (c) {
            this.aaK.s(uu);
            cs = this.aaK.cs(this.aaM);
            if (cs) {
                this.aaK.us();
                return;
            }
        }
        this.aaK.uw();
        this.aaK.d(this.aaN, this.aaL, this.aaM);
    }
}
