package com.baidu.swan.apps.v.a;

import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a dja;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        aAG();
        if (this.dja != null) {
            this.dja.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        aAG();
        if (this.dja != null) {
            this.dja.onResume();
        }
    }

    private void aAG() {
        com.baidu.swan.apps.core.g.a asz;
        if ((this.dja == null || this.dja.isDestroyed()) && (asz = com.baidu.swan.apps.core.turbo.d.ash().asz()) != null && (asz.ajP() instanceof com.baidu.swan.games.f.a)) {
            this.dja = (com.baidu.swan.games.f.a) asz.ajP();
        }
    }
}
