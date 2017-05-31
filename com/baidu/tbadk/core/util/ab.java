package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.lib.network.http.i {
    final /* synthetic */ aa aeA;
    private final /* synthetic */ int aeB;
    int aex = 0;
    int aey = 0;
    int aez = 0;
    private final /* synthetic */ Handler val$handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, Handler handler, int i) {
        this.aeA = aaVar;
        this.val$handler = handler;
        this.aeB = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void m(int i, int i2) {
        if (i2 > 0) {
            this.aex = i2 / 50;
        }
        this.aey += i - this.aez;
        this.aez = i;
        if (this.val$handler != null) {
            if (this.aey > this.aex || i == i2) {
                this.aey = 0;
                this.val$handler.sendMessage(this.val$handler.obtainMessage(this.aeB, i, i2));
            }
        }
    }
}
