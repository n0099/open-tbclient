package com.baidu.tbadk.core.util;

import android.os.Handler;
/* loaded from: classes.dex */
class x implements com.baidu.adp.lib.network.http.h {
    int aae = 0;
    int aaf = 0;
    int aag = 0;
    final /* synthetic */ w aah;
    private final /* synthetic */ Handler aai;
    private final /* synthetic */ int aaj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, Handler handler, int i) {
        this.aah = wVar;
        this.aai = handler;
        this.aaj = i;
    }

    @Override // com.baidu.adp.lib.network.http.h
    public void c(int i, int i2) {
        if (i2 > 0) {
            this.aae = i2 / 50;
        }
        this.aaf += i - this.aag;
        this.aag = i;
        if (this.aai != null) {
            if (this.aaf > this.aae || i == i2) {
                this.aaf = 0;
                this.aai.sendMessage(this.aai.obtainMessage(this.aaj, i, i2));
            }
        }
    }
}
