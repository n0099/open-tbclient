package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b bHN = com.baidu.rtc.camera.engine.a.b.Qw();
    private b bHS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bHS = bVar;
        this.bHN.bHI = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bHN.bHJ = bVar;
        return this;
    }

    public void aP(Context context) {
        this.bHS.aP(context);
    }
}
