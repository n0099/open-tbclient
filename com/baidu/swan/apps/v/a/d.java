package com.baidu.swan.apps.v.a;

import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a cYh;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        azy();
        if (this.cYh != null) {
            this.cYh.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        azy();
        if (this.cYh != null) {
            this.cYh.onResume();
        }
    }

    private void azy() {
        com.baidu.swan.apps.core.g.a arr;
        if ((this.cYh == null || this.cYh.isDestroyed()) && (arr = com.baidu.swan.apps.core.turbo.d.ara().arr()) != null && (arr.aiP() instanceof com.baidu.swan.games.f.a)) {
            this.cYh = (com.baidu.swan.games.f.a) arr.aiP();
        }
    }
}
