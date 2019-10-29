package com.baidu.swan.games.q.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes2.dex */
public class a {
    private g bDZ;
    private boolean bEa = true;

    private void dk(boolean z) {
        this.bEa = z;
        if (this.bDZ != null) {
            if (z) {
                this.bDZ.S(4, 1);
            } else {
                this.bDZ.gt(4);
            }
        }
    }

    public void a(g gVar) {
        this.bDZ = gVar;
        dk(this.bEa);
    }

    public void XV() {
        dk(true);
    }

    public void XW() {
        dk(false);
    }
}
