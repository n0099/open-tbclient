package com.baidu.swan.apps.v.a;

import android.support.annotation.Nullable;
/* loaded from: classes3.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a czx;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        atb();
        if (this.czx != null) {
            this.czx.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        atb();
        if (this.czx != null) {
            this.czx.onResume();
        }
    }

    private void atb() {
        com.baidu.swan.apps.core.g.a akT;
        if ((this.czx == null || this.czx.isDestroyed()) && (akT = com.baidu.swan.apps.core.turbo.d.akC().akT()) != null && (akT.acr() instanceof com.baidu.swan.games.f.a)) {
            this.czx = (com.baidu.swan.games.f.a) akT.acr();
        }
    }
}
