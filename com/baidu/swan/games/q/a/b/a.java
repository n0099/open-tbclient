package com.baidu.swan.games.q.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes2.dex */
public class a {
    private g bDi;
    private boolean bDj = true;

    private void dk(boolean z) {
        this.bDj = z;
        if (this.bDi != null) {
            if (z) {
                this.bDi.Q(4, 1);
            } else {
                this.bDi.gs(4);
            }
        }
    }

    public void a(g gVar) {
        this.bDi = gVar;
        dk(this.bDj);
    }

    public void XT() {
        dk(true);
    }

    public void XU() {
        dk(false);
    }
}
