package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ak afO;
    private final /* synthetic */ String afP;
    private final /* synthetic */ int afQ;
    private final /* synthetic */ String afR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar, String str, int i, String str2) {
        this.afO = akVar;
        this.afP = str;
        this.afQ = i;
        this.afR = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File vn;
        boolean e;
        boolean cK;
        vn = this.afO.vn();
        e = this.afO.e(vn, this.afP);
        if (e) {
            this.afO.t(vn);
            cK = this.afO.cK(this.afQ);
            if (cK) {
                this.afO.vl();
                return;
            }
        }
        this.afO.vp();
        this.afO.c(this.afR, this.afP, this.afQ);
    }
}
