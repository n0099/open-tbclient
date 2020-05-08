package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private b bvB;
    private com.baidu.rtc.camera.engine.a.b bvw = com.baidu.rtc.camera.engine.a.b.Nd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bvB = bVar;
        this.bvw.bvr = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bvw.bvs = bVar;
        return this;
    }

    public void aE(Context context) {
        this.bvB.aE(context);
    }
}
