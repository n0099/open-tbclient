package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.lib.network.http.i {
    int afm = 0;
    int afn = 0;
    int afo = 0;
    final /* synthetic */ aa afp;
    private final /* synthetic */ Handler afq;
    private final /* synthetic */ int afr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, Handler handler, int i) {
        this.afp = aaVar;
        this.afq = handler;
        this.afr = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void m(int i, int i2) {
        if (i2 > 0) {
            this.afm = i2 / 50;
        }
        this.afn += i - this.afo;
        this.afo = i;
        if (this.afq != null) {
            if (this.afn > this.afm || i == i2) {
                this.afn = 0;
                this.afq.sendMessage(this.afq.obtainMessage(this.afr, i, i2));
            }
        }
    }
}
