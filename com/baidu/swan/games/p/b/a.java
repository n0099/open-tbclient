package com.baidu.swan.games.p.b;

import com.baidu.swan.menu.h;
/* loaded from: classes2.dex */
public class a {
    private h bfe;
    private boolean bff = true;

    private void cz(boolean z) {
        this.bff = z;
        if (this.bfe != null) {
            if (z) {
                this.bfe.L(4, 1);
            } else {
                this.bfe.eV(4);
            }
        }
    }

    public void a(h hVar) {
        this.bfe = hVar;
        cz(this.bff);
    }

    public void OV() {
        cz(true);
    }

    public void OW() {
        cz(false);
    }
}
