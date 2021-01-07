package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes9.dex */
public class a {
    private g enp;
    private boolean enq = true;

    private void ij(boolean z) {
        this.enq = z;
        if (this.enp != null) {
            if (z) {
                this.enp.aA(4, 1);
            } else {
                this.enp.ng(4);
            }
        }
    }

    public void b(g gVar) {
        this.enp = gVar;
        ij(this.enq);
    }

    public void bbM() {
        ij(true);
    }

    public void bbN() {
        ij(false);
    }
}
