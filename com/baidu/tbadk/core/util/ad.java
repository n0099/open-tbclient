package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.i {
    int aap = 0;
    int aaq = 0;
    int aar = 0;
    final /* synthetic */ ac aas;
    private final /* synthetic */ Handler aat;
    private final /* synthetic */ int aau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.aas = acVar;
        this.aat = handler;
        this.aau = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void f(int i, int i2) {
        if (i2 > 0) {
            this.aap = i2 / 50;
        }
        this.aaq += i - this.aar;
        this.aar = i;
        if (this.aat != null) {
            if (this.aaq > this.aap || i == i2) {
                this.aaq = 0;
                this.aat.sendMessage(this.aat.obtainMessage(this.aau, i, i2));
            }
        }
    }
}
