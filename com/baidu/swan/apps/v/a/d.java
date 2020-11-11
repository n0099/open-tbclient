package com.baidu.swan.apps.v.a;

import android.support.annotation.Nullable;
/* loaded from: classes10.dex */
class d implements a {
    @Nullable
    private com.baidu.swan.games.f.a cZR;

    @Override // com.baidu.swan.apps.v.a.a
    public void onPause() {
        aAg();
        if (this.cZR != null) {
            this.cZR.onPause();
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    public void onResume() {
        aAg();
        if (this.cZR != null) {
            this.cZR.onResume();
        }
    }

    private void aAg() {
        com.baidu.swan.apps.core.g.a arZ;
        if ((this.cZR == null || this.cZR.isDestroyed()) && (arZ = com.baidu.swan.apps.core.turbo.d.arI().arZ()) != null && (arZ.ajx() instanceof com.baidu.swan.games.f.a)) {
            this.cZR = (com.baidu.swan.games.f.a) arZ.ajx();
        }
    }
}
