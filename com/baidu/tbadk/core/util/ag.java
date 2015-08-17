package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ ae aaF;
    private final /* synthetic */ String aaG;
    private final /* synthetic */ int aaH;
    private final /* synthetic */ String aaI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, String str, int i, String str2) {
        this.aaF = aeVar;
        this.aaG = str;
        this.aaH = i;
        this.aaI = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uu;
        boolean c;
        boolean cm;
        uu = this.aaF.uu();
        c = this.aaF.c(uu, this.aaG);
        if (c) {
            this.aaF.s(uu);
            cm = this.aaF.cm(this.aaH);
            if (cm) {
                this.aaF.us();
                return;
            }
        }
        this.aaF.uw();
        this.aaF.d(this.aaI, this.aaG, this.aaH);
    }
}
