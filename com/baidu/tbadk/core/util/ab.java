package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.lib.network.http.i {
    int aeY = 0;
    int aeZ = 0;
    int afa = 0;
    final /* synthetic */ aa afb;
    private final /* synthetic */ Handler afc;
    private final /* synthetic */ int afd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, Handler handler, int i) {
        this.afb = aaVar;
        this.afc = handler;
        this.afd = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void m(int i, int i2) {
        if (i2 > 0) {
            this.aeY = i2 / 50;
        }
        this.aeZ += i - this.afa;
        this.afa = i;
        if (this.afc != null) {
            if (this.aeZ > this.aeY || i == i2) {
                this.aeZ = 0;
                this.afc.sendMessage(this.afc.obtainMessage(this.afd, i, i2));
            }
        }
    }
}
