package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.i {
    int aaC = 0;
    int aaD = 0;
    int aaE = 0;
    final /* synthetic */ ac aaF;
    private final /* synthetic */ Handler aaG;
    private final /* synthetic */ int aaH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.aaF = acVar;
        this.aaG = handler;
        this.aaH = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void f(int i, int i2) {
        if (i2 > 0) {
            this.aaC = i2 / 50;
        }
        this.aaD += i - this.aaE;
        this.aaE = i;
        if (this.aaG != null) {
            if (this.aaD > this.aaC || i == i2) {
                this.aaD = 0;
                this.aaG.sendMessage(this.aaG.obtainMessage(this.aaH, i, i2));
            }
        }
    }
}
