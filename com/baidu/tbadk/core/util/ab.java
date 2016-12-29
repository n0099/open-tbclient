package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.lib.network.http.i {
    int aau = 0;
    int aav = 0;
    int aaw = 0;
    final /* synthetic */ aa aax;
    private final /* synthetic */ Handler aay;
    private final /* synthetic */ int aaz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, Handler handler, int i) {
        this.aax = aaVar;
        this.aay = handler;
        this.aaz = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void f(int i, int i2) {
        if (i2 > 0) {
            this.aau = i2 / 50;
        }
        this.aav += i - this.aaw;
        this.aaw = i;
        if (this.aay != null) {
            if (this.aav > this.aau || i == i2) {
                this.aav = 0;
                this.aay.sendMessage(this.aay.obtainMessage(this.aaz, i, i2));
            }
        }
    }
}
