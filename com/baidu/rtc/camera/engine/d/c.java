package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b aWW = com.baidu.rtc.camera.engine.a.b.Fs();
    private b aXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.aXb = bVar;
        this.aWW.aWR = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.aWW.aWS = bVar;
        return this;
    }

    public void aY(Context context) {
        this.aXb.aY(context);
    }
}
