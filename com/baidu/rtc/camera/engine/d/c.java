package com.baidu.rtc.camera.engine.d;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c {
    private com.baidu.rtc.camera.engine.a.b bvr = com.baidu.rtc.camera.engine.a.b.Ne();
    private b bvw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.rtc.camera.engine.b.a aVar) {
        this.bvw = bVar;
        this.bvr.bvm = aVar;
    }

    public c a(com.baidu.rtc.camera.engine.b.b bVar) {
        this.bvr.bvn = bVar;
        return this;
    }

    public void aQ(Context context) {
        this.bvw.aQ(context);
    }
}
