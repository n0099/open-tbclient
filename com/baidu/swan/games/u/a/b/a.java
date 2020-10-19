package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes10.dex */
public class a {
    private h dKL;
    private boolean dKM = true;

    private void hd(boolean z) {
        this.dKM = z;
        if (this.dKL != null) {
            if (z) {
                this.dKL.aA(4, 1);
            } else {
                this.dKL.mi(4);
            }
        }
    }

    public void b(h hVar) {
        this.dKL = hVar;
        hd(this.dKM);
    }

    public void aSA() {
        hd(true);
    }

    public void aSB() {
        hd(false);
    }
}
