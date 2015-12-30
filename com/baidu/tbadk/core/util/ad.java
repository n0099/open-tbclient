package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.h {
    int abu = 0;
    int abv = 0;
    int abw = 0;
    final /* synthetic */ ac abx;
    private final /* synthetic */ Handler aby;
    private final /* synthetic */ int abz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.abx = acVar;
        this.aby = handler;
        this.abz = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.abu = i2 / 50;
        }
        this.abv += i - this.abw;
        this.abw = i;
        if (this.aby != null) {
            if (this.abv > this.abu || i == i2) {
                this.abv = 0;
                this.aby.sendMessage(this.aby.obtainMessage(this.abz, i, i2));
            }
        }
    }
}
