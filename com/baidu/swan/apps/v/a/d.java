package com.baidu.swan.apps.v.a;

import android.support.annotation.Nullable;
/* loaded from: classes8.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a cxw;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        asr();
        if (this.cxw != null) {
            this.cxw.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        asr();
        if (this.cxw != null) {
            this.cxw.onResume();
        }
    }

    private void asr() {
        com.baidu.swan.apps.core.g.a akj;
        if ((this.cxw == null || this.cxw.isDestroyed()) && (akj = com.baidu.swan.apps.core.turbo.d.ajS().akj()) != null && (akj.abI() instanceof com.baidu.swan.games.f.a)) {
            this.cxw = (com.baidu.swan.games.f.a) akj.abI();
        }
    }
}
