package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class x implements com.baidu.adp.lib.network.http.h {
    int ZV = 0;
    int ZW = 0;
    int ZX = 0;
    final /* synthetic */ w ZY;
    private final /* synthetic */ Handler ZZ;
    private final /* synthetic */ int aaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, Handler handler, int i) {
        this.ZY = wVar;
        this.ZZ = handler;
        this.aaa = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.ZV = i2 / 50;
        }
        this.ZW += i - this.ZX;
        this.ZX = i;
        if (this.ZZ != null) {
            if (this.ZW > this.ZV || i == i2) {
                this.ZW = 0;
                this.ZZ.sendMessage(this.ZZ.obtainMessage(this.aaa, i, i2));
            }
        }
    }
}
