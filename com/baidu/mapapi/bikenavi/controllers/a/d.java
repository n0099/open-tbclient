package com.baidu.mapapi.bikenavi.controllers.a;

import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
/* loaded from: classes2.dex */
public final class d implements com.baidu.platform.comapi.wnplatform.m.c {
    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public int a(String str, boolean z) {
        IBTTSPlayer iBTTSPlayer;
        IBTTSPlayer iBTTSPlayer2;
        iBTTSPlayer = a.f7014b;
        if (iBTTSPlayer != null) {
            iBTTSPlayer2 = a.f7014b;
            return iBTTSPlayer2.playTTSText(str, z);
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public int b() {
        return 1;
    }

    @Override // com.baidu.platform.comapi.wnplatform.m.c
    public void c() {
        throw new UnsupportedOperationException("release Unsupported");
    }
}
