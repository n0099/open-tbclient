package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.i {
    int WS = 0;
    int WT = 0;
    int WU = 0;
    final /* synthetic */ ac WV;
    private final /* synthetic */ Handler WW;
    private final /* synthetic */ int WX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.WV = acVar;
        this.WW = handler;
        this.WX = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void d(int i, int i2) {
        if (i2 > 0) {
            this.WS = i2 / 50;
        }
        this.WT += i - this.WU;
        this.WU = i;
        if (this.WW != null) {
            if (this.WT > this.WS || i == i2) {
                this.WT = 0;
                this.WW.sendMessage(this.WW.obtainMessage(this.WX, i, i2));
            }
        }
    }
}
