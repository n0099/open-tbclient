package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes8.dex */
public class a {
    private h dwJ;
    private boolean dwK = true;

    private void gJ(boolean z) {
        this.dwK = z;
        if (this.dwJ != null) {
            if (z) {
                this.dwJ.aB(4, 1);
            } else {
                this.dwJ.lA(4);
            }
        }
    }

    public void b(h hVar) {
        this.dwJ = hVar;
        gJ(this.dwK);
    }

    public void aPg() {
        gJ(true);
    }

    public void aPh() {
        gJ(false);
    }
}
