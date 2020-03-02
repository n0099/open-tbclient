package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b aWI = com.baidu.rtc.camera.engine.a.b.Fn();
    private b aWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.aWN = bVar;
        this.aWI.aWD = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.aWI.aWE = bVar;
        return this;
    }

    public void aZ(Context context) {
        this.aWN.aZ(context);
    }
}
