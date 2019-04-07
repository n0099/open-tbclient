package com.baidu.swan.games.p.b;

import com.baidu.swan.menu.h;
/* loaded from: classes2.dex */
public class a {
    private h bfi;
    private boolean bfj = true;

    private void cz(boolean z) {
        this.bfj = z;
        if (this.bfi != null) {
            if (z) {
                this.bfi.L(4, 1);
            } else {
                this.bfi.eU(4);
            }
        }
    }

    public void a(h hVar) {
        this.bfi = hVar;
        cz(this.bfj);
    }

    public void OT() {
        cz(true);
    }

    public void OU() {
        cz(false);
    }
}
