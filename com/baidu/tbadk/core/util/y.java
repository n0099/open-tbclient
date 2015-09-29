package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class y implements com.baidu.adp.lib.network.http.h {
    int ZY = 0;
    int ZZ = 0;
    int aaa = 0;
    final /* synthetic */ x aab;
    private final /* synthetic */ Handler aac;
    private final /* synthetic */ int aad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, Handler handler, int i) {
        this.aab = xVar;
        this.aac = handler;
        this.aad = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.ZY = i2 / 50;
        }
        this.ZZ += i - this.aaa;
        this.aaa = i;
        if (this.aac != null) {
            if (this.ZZ > this.ZY || i == i2) {
                this.ZZ = 0;
                this.aac.sendMessage(this.aac.obtainMessage(this.aad, i, i2));
            }
        }
    }
}
