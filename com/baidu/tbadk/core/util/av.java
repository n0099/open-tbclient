package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    final /* synthetic */ at Vb;
    private final /* synthetic */ String Vc;
    private final /* synthetic */ int Vd;
    private final /* synthetic */ String Ve;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar, String str, int i, String str2) {
        this.Vb = atVar;
        this.Vc = str;
        this.Vd = i;
        this.Ve = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File sP;
        boolean c;
        boolean cc;
        sP = this.Vb.sP();
        c = this.Vb.c(sP, this.Vc);
        if (c) {
            this.Vb.o(sP);
            cc = this.Vb.cc(this.Vd);
            if (cc) {
                this.Vb.sN();
                return;
            }
        }
        this.Vb.sR();
        this.Vb.d(this.Ve, this.Vc, this.Vd);
    }
}
