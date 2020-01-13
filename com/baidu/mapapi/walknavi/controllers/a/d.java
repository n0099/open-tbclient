package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
/* loaded from: classes6.dex */
final class d implements com.baidu.platform.comapi.wnplatform.m.c {
    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public int b() {
        return 1;
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public int a(String str, boolean z) {
        IWTTSPlayer iWTTSPlayer;
        IWTTSPlayer iWTTSPlayer2;
        iWTTSPlayer = a.b;
        if (iWTTSPlayer != null) {
            iWTTSPlayer2 = a.b;
            return iWTTSPlayer2.playTTSText(str, z);
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public void c() {
        throw new UnsupportedOperationException("release Unsupported");
    }
}
