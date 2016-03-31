package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.lib.network.http.i {
    int abc = 0;
    int abd = 0;
    int abe = 0;
    final /* synthetic */ ac abf;
    private final /* synthetic */ Handler abg;
    private final /* synthetic */ int abh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, Handler handler, int i) {
        this.abf = acVar;
        this.abg = handler;
        this.abh = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void d(int i, int i2) {
        if (i2 > 0) {
            this.abc = i2 / 50;
        }
        this.abd += i - this.abe;
        this.abe = i;
        if (this.abg != null) {
            if (this.abd > this.abc || i == i2) {
                this.abd = 0;
                this.abg.sendMessage(this.abg.obtainMessage(this.abh, i, i2));
            }
        }
    }
}
