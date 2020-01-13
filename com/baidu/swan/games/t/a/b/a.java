package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes10.dex */
public class a {
    private h cnT;
    private boolean cnU = true;

    private void eA(boolean z) {
        this.cnU = z;
        if (this.cnT != null) {
            if (z) {
                this.cnT.ap(4, 1);
            } else {
                this.cnT.hY(4);
            }
        }
    }

    public void b(h hVar) {
        this.cnT = hVar;
        eA(this.cnU);
    }

    public void ang() {
        eA(true);
    }

    public void anh() {
        eA(false);
    }
}
