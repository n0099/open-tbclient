package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
/* loaded from: classes15.dex */
final class d implements com.baidu.platform.comapi.wnplatform.n.c {
    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public int b() {
        return 1;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public int a(String str, boolean z) {
        IBTTSPlayer iBTTSPlayer;
        IBTTSPlayer iBTTSPlayer2;
        iBTTSPlayer = a.f2753b;
        if (iBTTSPlayer != null) {
            iBTTSPlayer2 = a.f2753b;
            return iBTTSPlayer2.playTTSText(str, z);
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.c
    public void c() {
        throw new UnsupportedOperationException("release Unsupported");
    }
}
