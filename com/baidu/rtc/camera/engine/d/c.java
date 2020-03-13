package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b aWJ = com.baidu.rtc.camera.engine.a.b.Fn();
    private b aWO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.aWO = bVar;
        this.aWJ.aWE = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.aWJ.aWF = bVar;
        return this;
    }

    public void aZ(Context context) {
        this.aWO.aZ(context);
    }
}
