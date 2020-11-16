package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes16.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b clV = com.baidu.rtc.camera.engine.a.b.adu();
    private b cma;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.cma = bVar;
        this.clV.clQ = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.clV.clR = bVar;
        return this;
    }

    public void aZ(Context context) {
        this.cma.aZ(context);
    }
}
