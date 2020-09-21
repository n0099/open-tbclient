package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes15.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b bPR = com.baidu.rtc.camera.engine.a.b.Xq();
    private b bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bPW = bVar;
        this.bPR.bPM = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bPR.bPN = bVar;
        return this;
    }

    public void aU(Context context) {
        this.bPW.aU(context);
    }
}
