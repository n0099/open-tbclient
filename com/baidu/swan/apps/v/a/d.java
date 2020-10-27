package com.baidu.swan.apps.v.a;

import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a cTY;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        axG();
        if (this.cTY != null) {
            this.cTY.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        axG();
        if (this.cTY != null) {
            this.cTY.onResume();
        }
    }

    private void axG() {
        com.baidu.swan.apps.core.g.a apz;
        if ((this.cTY == null || this.cTY.isDestroyed()) && (apz = com.baidu.swan.apps.core.turbo.d.aph().apz()) != null && (apz.agX() instanceof com.baidu.swan.games.f.a)) {
            this.cTY = (com.baidu.swan.games.f.a) apz.agX();
        }
    }
}
