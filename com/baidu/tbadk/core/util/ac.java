package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ac implements com.baidu.adp.lib.network.http.h {
    int abQ = 0;
    int abR = 0;
    int abS = 0;
    final /* synthetic */ ab abT;
    private final /* synthetic */ Handler abU;
    private final /* synthetic */ int abV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, Handler handler, int i) {
        this.abT = abVar;
        this.abU = handler;
        this.abV = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void d(int i, int i2) {
        if (i2 > 0) {
            this.abQ = i2 / 50;
        }
        this.abR += i - this.abS;
        this.abS = i;
        if (this.abU != null) {
            if (this.abR > this.abQ || i == i2) {
                this.abR = 0;
                this.abU.sendMessage(this.abU.obtainMessage(this.abV, i, i2));
            }
        }
    }
}
