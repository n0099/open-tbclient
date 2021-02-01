package com.baidu.swan.apps.v.a;

import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a dhw;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        aAD();
        if (this.dhw != null) {
            this.dhw.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        aAD();
        if (this.dhw != null) {
            this.dhw.onResume();
        }
    }

    private void aAD() {
        com.baidu.swan.apps.core.g.a asw;
        if ((this.dhw == null || this.dhw.isDestroyed()) && (asw = com.baidu.swan.apps.core.turbo.d.ase().asw()) != null && (asw.ajM() instanceof com.baidu.swan.games.f.a)) {
            this.dhw = (com.baidu.swan.games.f.a) asw.ajM();
        }
    }
}
