package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ av Js;
    private final /* synthetic */ String Jt;
    private final /* synthetic */ int Ju;
    private final /* synthetic */ String Jv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar, String str, int i, String str2) {
        this.Js = avVar;
        this.Jt = str;
        this.Ju = i;
        this.Jv = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File pz;
        boolean c;
        boolean ca;
        pz = this.Js.pz();
        c = this.Js.c(pz, this.Jt);
        if (c) {
            this.Js.o(pz);
            ca = this.Js.ca(this.Ju);
            if (ca) {
                this.Js.px();
                return;
            }
        }
        this.Js.pB();
        this.Js.d(this.Jv, this.Jt, this.Ju);
    }
}
