package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Runnable {
    final /* synthetic */ aq VI;
    private final /* synthetic */ String VJ;
    private final /* synthetic */ int VK;
    private final /* synthetic */ String VL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar, String str, int i, String str2) {
        this.VI = aqVar;
        this.VJ = str;
        this.VK = i;
        this.VL = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File ts;
        boolean c;
        boolean cg;
        ts = this.VI.ts();
        c = this.VI.c(ts, this.VJ);
        if (c) {
            this.VI.q(ts);
            cg = this.VI.cg(this.VK);
            if (cg) {
                this.VI.tq();
                return;
            }
        }
        this.VI.tu();
        this.VI.d(this.VL, this.VJ, this.VK);
    }
}
