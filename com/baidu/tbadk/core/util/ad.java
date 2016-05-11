package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.i {
    int WC = 0;
    int WD = 0;
    int WE = 0;
    final /* synthetic */ ac WF;
    private final /* synthetic */ Handler WG;
    private final /* synthetic */ int WH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.WF = acVar;
        this.WG = handler;
        this.WH = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void d(int i, int i2) {
        if (i2 > 0) {
            this.WC = i2 / 50;
        }
        this.WD += i - this.WE;
        this.WE = i;
        if (this.WG != null) {
            if (this.WD > this.WC || i == i2) {
                this.WD = 0;
                this.WG.sendMessage(this.WG.obtainMessage(this.WH, i, i2));
            }
        }
    }
}
