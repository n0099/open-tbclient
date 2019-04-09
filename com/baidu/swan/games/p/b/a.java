package com.baidu.swan.games.p.b;

import com.baidu.swan.menu.h;
/* loaded from: classes2.dex */
public class a {
    private h bfj;
    private boolean bfk = true;

    private void cz(boolean z) {
        this.bfk = z;
        if (this.bfj != null) {
            if (z) {
                this.bfj.L(4, 1);
            } else {
                this.bfj.eU(4);
            }
        }
    }

    public void a(h hVar) {
        this.bfj = hVar;
        cz(this.bfk);
    }

    public void OT() {
        cz(true);
    }

    public void OU() {
        cz(false);
    }
}
