package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.i {
    int XB = 0;
    int XC = 0;
    int XD = 0;
    final /* synthetic */ ac XE;
    private final /* synthetic */ Handler XF;
    private final /* synthetic */ int XG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.XE = acVar;
        this.XF = handler;
        this.XG = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void d(int i, int i2) {
        if (i2 > 0) {
            this.XB = i2 / 50;
        }
        this.XC += i - this.XD;
        this.XD = i;
        if (this.XF != null) {
            if (this.XC > this.XB || i == i2) {
                this.XC = 0;
                this.XF.sendMessage(this.XF.obtainMessage(this.XG, i, i2));
            }
        }
    }
}
