package com.baidu.swan.apps.v.a;

import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a dfl;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        aAf();
        if (this.dfl != null) {
            this.dfl.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        aAf();
        if (this.dfl != null) {
            this.dfl.onResume();
        }
    }

    private void aAf() {
        com.baidu.swan.apps.core.g.a arX;
        if ((this.dfl == null || this.dfl.isDestroyed()) && (arX = com.baidu.swan.apps.core.turbo.d.arG().arX()) != null && (arX.ajo() instanceof com.baidu.swan.games.f.a)) {
            this.dfl = (com.baidu.swan.games.f.a) arX.ajo();
        }
    }
}
