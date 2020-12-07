package com.baidu.swan.apps.v.a;

import android.support.annotation.Nullable;
/* loaded from: classes25.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a dfg;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        aCH();
        if (this.dfg != null) {
            this.dfg.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        aCH();
        if (this.dfg != null) {
            this.dfg.onResume();
        }
    }

    private void aCH() {
        com.baidu.swan.apps.core.g.a auz;
        if ((this.dfg == null || this.dfg.isDestroyed()) && (auz = com.baidu.swan.apps.core.turbo.d.aui().auz()) != null && (auz.alX() instanceof com.baidu.swan.games.f.a)) {
            this.dfg = (com.baidu.swan.games.f.a) auz.alX();
        }
    }
}
