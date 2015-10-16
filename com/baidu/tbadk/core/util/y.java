package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class y implements com.baidu.adp.lib.network.http.h {
    int aaa = 0;
    int aab = 0;
    int aac = 0;
    final /* synthetic */ x aad;
    private final /* synthetic */ Handler aae;
    private final /* synthetic */ int aaf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, Handler handler, int i) {
        this.aad = xVar;
        this.aae = handler;
        this.aaf = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.aaa = i2 / 50;
        }
        this.aab += i - this.aac;
        this.aac = i;
        if (this.aae != null) {
            if (this.aab > this.aaa || i == i2) {
                this.aab = 0;
                this.aae.sendMessage(this.aae.obtainMessage(this.aaf, i, i2));
            }
        }
    }
}
