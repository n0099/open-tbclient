package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b aWH = com.baidu.rtc.camera.engine.a.b.Fl();
    private b aWM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.aWM = bVar;
        this.aWH.aWC = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.aWH.aWD = bVar;
        return this;
    }

    public void aZ(Context context) {
        this.aWM.aZ(context);
    }
}
