package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.lib.network.http.i {
    int aeF = 0;
    int aeG = 0;
    int aeH = 0;
    final /* synthetic */ aa aeI;
    private final /* synthetic */ Handler aeJ;
    private final /* synthetic */ int aeK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, Handler handler, int i) {
        this.aeI = aaVar;
        this.aeJ = handler;
        this.aeK = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void m(int i, int i2) {
        if (i2 > 0) {
            this.aeF = i2 / 50;
        }
        this.aeG += i - this.aeH;
        this.aeH = i;
        if (this.aeJ != null) {
            if (this.aeG > this.aeF || i == i2) {
                this.aeG = 0;
                this.aeJ.sendMessage(this.aeJ.obtainMessage(this.aeK, i, i2));
            }
        }
    }
}
