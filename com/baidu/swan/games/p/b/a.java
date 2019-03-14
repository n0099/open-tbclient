package com.baidu.swan.games.p.b;

import com.baidu.swan.menu.h;
/* loaded from: classes2.dex */
public class a {
    private h bff;
    private boolean bfg = true;

    private void cz(boolean z) {
        this.bfg = z;
        if (this.bff != null) {
            if (z) {
                this.bff.L(4, 1);
            } else {
                this.bff.eV(4);
            }
        }
    }

    public void a(h hVar) {
        this.bff = hVar;
        cz(this.bfg);
    }

    public void OV() {
        cz(true);
    }

    public void OW() {
        cz(false);
    }
}
