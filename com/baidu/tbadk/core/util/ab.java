package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ab implements com.baidu.adp.lib.network.http.i {
    int aba = 0;
    int abb = 0;
    int abc = 0;
    final /* synthetic */ aa abd;
    private final /* synthetic */ Handler abe;
    private final /* synthetic */ int abf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, Handler handler, int i) {
        this.abd = aaVar;
        this.abe = handler;
        this.abf = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void f(int i, int i2) {
        if (i2 > 0) {
            this.aba = i2 / 50;
        }
        this.abb += i - this.abc;
        this.abc = i;
        if (this.abe != null) {
            if (this.abb > this.aba || i == i2) {
                this.abb = 0;
                this.abe.sendMessage(this.abe.obtainMessage(this.abf, i, i2));
            }
        }
    }
}
