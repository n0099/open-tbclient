package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes4.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b aRq = com.baidu.rtc.camera.engine.a.b.Ct();
    private b aRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.aRv = bVar;
        this.aRq.aRl = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.aRq.aRm = bVar;
        return this;
    }

    public void aV(Context context) {
        this.aRv.aV(context);
    }
}
