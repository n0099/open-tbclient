package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class aa implements com.baidu.adp.lib.network.http.i {
    int ZI = 0;
    int ZJ = 0;
    int ZK = 0;
    final /* synthetic */ z ZL;
    private final /* synthetic */ Handler ZM;
    private final /* synthetic */ int ZN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, Handler handler, int i) {
        this.ZL = zVar;
        this.ZM = handler;
        this.ZN = i;
    }

    @Override // com.baidu.adp.lib.network.http.i
    public void f(int i, int i2) {
        if (i2 > 0) {
            this.ZI = i2 / 50;
        }
        this.ZJ += i - this.ZK;
        this.ZK = i;
        if (this.ZM != null) {
            if (this.ZJ > this.ZI || i == i2) {
                this.ZJ = 0;
                this.ZM.sendMessage(this.ZM.obtainMessage(this.ZN, i, i2));
            }
        }
    }
}
