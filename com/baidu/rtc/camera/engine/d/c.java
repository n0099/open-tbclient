package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes11.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b cnH = com.baidu.rtc.camera.engine.a.b.aec();
    private b cnM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.cnM = bVar;
        this.cnH.cnC = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.cnH.cnD = bVar;
        return this;
    }

    public void aZ(Context context) {
        this.cnM.aZ(context);
    }
}
