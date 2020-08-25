package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes11.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b bNN = com.baidu.rtc.camera.engine.a.b.WH();
    private b bNS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bNS = bVar;
        this.bNN.bNI = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bNN.bNJ = bVar;
        return this;
    }

    public void aV(Context context) {
        this.bNS.aV(context);
    }
}
