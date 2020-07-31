package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes7.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b bIm = com.baidu.rtc.camera.engine.a.b.QL();
    private b bIr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bIr = bVar;
        this.bIm.bIh = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bIm.bIi = bVar;
        return this;
    }

    public void aQ(Context context) {
        this.bIr.aQ(context);
    }
}
