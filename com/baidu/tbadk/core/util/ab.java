package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.lib.network.http.i {
    int afn = 0;
    int afo = 0;
    int afp = 0;
    final /* synthetic */ aa afq;
    private final /* synthetic */ Handler afr;
    private final /* synthetic */ int afs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, Handler handler, int i) {
        this.afq = aaVar;
        this.afr = handler;
        this.afs = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void m(int i, int i2) {
        if (i2 > 0) {
            this.afn = i2 / 50;
        }
        this.afo += i - this.afp;
        this.afp = i;
        if (this.afr != null) {
            if (this.afo > this.afn || i == i2) {
                this.afo = 0;
                this.afr.sendMessage(this.afr.obtainMessage(this.afs, i, i2));
            }
        }
    }
}
