package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes10.dex */
public class a {
    private h dTi;
    private boolean dTj = true;

    private void hq(boolean z) {
        this.dTj = z;
        if (this.dTi != null) {
            if (z) {
                this.dTi.aB(4, 1);
            } else {
                this.dTi.mt(4);
            }
        }
    }

    public void b(h hVar) {
        this.dTi = hVar;
        hq(this.dTj);
    }

    public void aUu() {
        hq(true);
    }

    public void aUv() {
        hq(false);
    }
}
