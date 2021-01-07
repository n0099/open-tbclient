package com.baidu.swan.apps.v.a;

import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a dka;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        aDZ();
        if (this.dka != null) {
            this.dka.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        aDZ();
        if (this.dka != null) {
            this.dka.onResume();
        }
    }

    private void aDZ() {
        com.baidu.swan.apps.core.g.a avS;
        if ((this.dka == null || this.dka.isDestroyed()) && (avS = com.baidu.swan.apps.core.turbo.d.avB().avS()) != null && (avS.ani() instanceof com.baidu.swan.games.f.a)) {
            this.dka = (com.baidu.swan.games.f.a) avS.ani();
        }
    }
}
