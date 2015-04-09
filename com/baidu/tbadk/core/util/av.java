package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    final /* synthetic */ at Vd;
    private final /* synthetic */ String Ve;
    private final /* synthetic */ int Vf;
    private final /* synthetic */ String Vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar, String str, int i, String str2) {
        this.Vd = atVar;
        this.Ve = str;
        this.Vf = i;
        this.Vg = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File sP;
        boolean c;
        boolean cc;
        sP = this.Vd.sP();
        c = this.Vd.c(sP, this.Ve);
        if (c) {
            this.Vd.o(sP);
            cc = this.Vd.cc(this.Vf);
            if (cc) {
                this.Vd.sN();
                return;
            }
        }
        this.Vd.sR();
        this.Vd.d(this.Vg, this.Ve, this.Vf);
    }
}
