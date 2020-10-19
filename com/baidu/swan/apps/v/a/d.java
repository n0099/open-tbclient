package com.baidu.swan.apps.v.a;

import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a cLC;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        avM();
        if (this.cLC != null) {
            this.cLC.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        avM();
        if (this.cLC != null) {
            this.cLC.onResume();
        }
    }

    private void avM() {
        com.baidu.swan.apps.core.g.a anE;
        if ((this.cLC == null || this.cLC.isDestroyed()) && (anE = com.baidu.swan.apps.core.turbo.d.ann().anE()) != null && (anE.afd() instanceof com.baidu.swan.games.f.a)) {
            this.cLC = (com.baidu.swan.games.f.a) anE.afd();
        }
    }
}
