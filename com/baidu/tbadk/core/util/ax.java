package com.baidu.tbadk.core.util;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ av Jp;
    private final /* synthetic */ String Jq;
    private final /* synthetic */ int Jr;
    private final /* synthetic */ String Js;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar, String str, int i, String str2) {
        this.Jp = avVar;
        this.Jq = str;
        this.Jr = i;
        this.Js = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        File ps;
        boolean c;
        boolean ca;
        ps = this.Jp.ps();
        c = this.Jp.c(ps, this.Jq);
        if (c) {
            this.Jp.o(ps);
            ca = this.Jp.ca(this.Jr);
            if (ca) {
                this.Jp.pq();
                return;
            }
        }
        this.Jp.pu();
        this.Jp.d(this.Js, this.Jq, this.Jr);
    }
}
