package com.baidu.swan.apps.v.a;

import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a dka;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        aDY();
        if (this.dka != null) {
            this.dka.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        aDY();
        if (this.dka != null) {
            this.dka.onResume();
        }
    }

    private void aDY() {
        com.baidu.swan.apps.core.g.a avR;
        if ((this.dka == null || this.dka.isDestroyed()) && (avR = com.baidu.swan.apps.core.turbo.d.avA().avR()) != null && (avR.anh() instanceof com.baidu.swan.games.f.a)) {
            this.dka = (com.baidu.swan.games.f.a) avR.anh();
        }
    }
}
