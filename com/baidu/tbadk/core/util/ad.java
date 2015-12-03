package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.h {
    int aaQ = 0;
    int aaR = 0;
    int aaS = 0;
    final /* synthetic */ ac aaT;
    private final /* synthetic */ Handler aaU;
    private final /* synthetic */ int aaV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.aaT = acVar;
        this.aaU = handler;
        this.aaV = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.aaQ = i2 / 50;
        }
        this.aaR += i - this.aaS;
        this.aaS = i;
        if (this.aaU != null) {
            if (this.aaR > this.aaQ || i == i2) {
                this.aaR = 0;
                this.aaU.sendMessage(this.aaU.obtainMessage(this.aaV, i, i2));
            }
        }
    }
}
