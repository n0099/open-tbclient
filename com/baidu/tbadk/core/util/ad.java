package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.i {
    int aff = 0;
    int afg = 0;
    int afh = 0;
    final /* synthetic */ ac afi;
    private final /* synthetic */ int afj;
    private final /* synthetic */ Handler val$handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.afi = acVar;
        this.val$handler = handler;
        this.afj = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void m(int i, int i2) {
        if (i2 > 0) {
            this.aff = i2 / 50;
        }
        this.afg += i - this.afh;
        this.afh = i;
        if (this.val$handler != null) {
            if (this.afg > this.aff || i == i2) {
                this.afg = 0;
                this.val$handler.sendMessage(this.val$handler.obtainMessage(this.afj, i, i2));
            }
        }
    }
}
