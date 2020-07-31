package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
/* loaded from: classes10.dex */
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
        IBTTSPlayer iBTTSPlayer;
        IBTTSPlayer iBTTSPlayer2;
        iBTTSPlayer = a.b;
        if (iBTTSPlayer != null) {
            iBTTSPlayer2 = a.b;
            return iBTTSPlayer2.playTTSText(str, z);
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public void c() {
        throw new UnsupportedOperationException("release Unsupported");
    }
}
