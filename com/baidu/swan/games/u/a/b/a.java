package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes8.dex */
public class a {
    private h dwF;
    private boolean dwG = true;

    private void gI(boolean z) {
        this.dwG = z;
        if (this.dwF != null) {
            if (z) {
                this.dwF.aB(4, 1);
            } else {
                this.dwF.lA(4);
            }
        }
    }

    public void b(h hVar) {
        this.dwF = hVar;
        gI(this.dwG);
    }

    public void aPg() {
        gI(true);
    }

    public void aPh() {
        gI(false);
    }
}
