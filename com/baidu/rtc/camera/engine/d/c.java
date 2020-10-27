package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes11.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b chL = com.baidu.rtc.camera.engine.a.b.abC();
    private b chQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.chQ = bVar;
        this.chL.chG = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.chL.chH = bVar;
        return this;
    }

    public void aZ(Context context) {
        this.chQ.aZ(context);
    }
}
