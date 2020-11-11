package com.baidu.mapapi.walknavi.controllers.a;

import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
/* loaded from: classes7.dex */
final class e implements com.baidu.platform.comapi.wnplatform.n.c {
    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public int b() {
        return 1;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public int a(String str, boolean z) {
        IWTTSPlayer iWTTSPlayer;
        IWTTSPlayer iWTTSPlayer2;
        iWTTSPlayer = a.f2171a;
        if (iWTTSPlayer != null) {
            iWTTSPlayer2 = a.f2171a;
            return iWTTSPlayer2.playTTSText(str, z);
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public void c() {
        throw new UnsupportedOperationException("release Unsupported");
    }
}
