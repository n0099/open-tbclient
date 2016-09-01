package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ am abd;
    private final /* synthetic */ String abe;
    private final /* synthetic */ int abf;
    private final /* synthetic */ String abg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar, String str, int i, String str2) {
        this.abd = amVar;
        this.abe = str;
        this.abf = i;
        this.abg = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File uW;
        boolean c;
        boolean cJ;
        uW = this.abd.uW();
        c = this.abd.c(uW, this.abe);
        if (c) {
            this.abd.q(uW);
            cJ = this.abd.cJ(this.abf);
            if (cJ) {
                this.abd.uU();
                return;
            }
        }
        this.abd.uY();
        this.abd.c(this.abg, this.abe, this.abf);
    }
}
