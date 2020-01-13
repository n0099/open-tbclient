package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes5.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b aSi = com.baidu.rtc.camera.engine.a.b.CP();
    private b aSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.aSn = bVar;
        this.aSi.aSd = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.aSi.aSe = bVar;
        return this;
    }

    public void aV(Context context) {
        this.aSn.aV(context);
    }
}
