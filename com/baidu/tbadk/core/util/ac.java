package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class ac implements com.baidu.adp.lib.network.http.h {
    int UU = 0;
    int UV = 0;
    int UW = 0;
    final /* synthetic */ ab UX;
    private final /* synthetic */ Handler UY;
    private final /* synthetic */ int UZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, Handler handler, int i) {
        this.UX = abVar;
        this.UY = handler;
        this.UZ = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void onProgress(int i, int i2) {
        if (i2 > 0) {
            this.UU = i2 / 50;
        }
        this.UV += i - this.UW;
        this.UW = i;
        if (this.UY != null) {
            if (this.UV > this.UU || i == i2) {
                this.UV = 0;
                this.UY.sendMessage(this.UY.obtainMessage(this.UZ, i, i2));
            }
        }
    }
}
