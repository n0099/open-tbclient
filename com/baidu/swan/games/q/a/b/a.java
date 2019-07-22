package com.baidu.swan.games.q.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes2.dex */
public class a {
    private g bkN;
    private boolean bkO = true;

    private void cT(boolean z) {
        this.bkO = z;
        if (this.bkN != null) {
            if (z) {
                this.bkN.M(4, 1);
            } else {
                this.bkN.fx(4);
            }
        }
    }

    public void a(g gVar) {
        this.bkN = gVar;
        cT(this.bkO);
    }

    public void Ta() {
        cT(true);
    }

    public void Tb() {
        cT(false);
    }
}
