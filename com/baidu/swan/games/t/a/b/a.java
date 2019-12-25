package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes9.dex */
public class a {
    private h cnG;
    private boolean cnH = true;

    private void ev(boolean z) {
        this.cnH = z;
        if (this.cnG != null) {
            if (z) {
                this.cnG.al(4, 1);
            } else {
                this.cnG.hY(4);
            }
        }
    }

    public void b(h hVar) {
        this.cnG = hVar;
        ev(this.cnH);
    }

    public void amN() {
        ev(true);
    }

    public void amO() {
        ev(false);
    }
}
