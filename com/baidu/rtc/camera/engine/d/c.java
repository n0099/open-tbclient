package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes11.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b csR = com.baidu.rtc.camera.engine.a.b.agC();
    private b csW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.csW = bVar;
        this.csR.csM = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.csR.csN = bVar;
        return this;
    }

    public void bF(Context context) {
        this.csW.bF(context);
    }
}
