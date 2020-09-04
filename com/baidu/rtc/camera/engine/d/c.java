package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes11.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b bNR = com.baidu.rtc.camera.engine.a.b.WH();
    private b bNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bNW = bVar;
        this.bNR.bNM = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bNR.bNN = bVar;
        return this;
    }

    public void aV(Context context) {
        this.bNW.aV(context);
    }
}
