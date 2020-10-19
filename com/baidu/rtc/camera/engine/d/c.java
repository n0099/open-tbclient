package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes11.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b bZn = com.baidu.rtc.camera.engine.a.b.ZI();
    private b bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bZs = bVar;
        this.bZn.bZi = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bZn.bZj = bVar;
        return this;
    }

    public void aZ(Context context) {
        this.bZs.aZ(context);
    }
}
