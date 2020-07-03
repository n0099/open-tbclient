package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h dgR;
    private boolean dgS = true;

    private void fV(boolean z) {
        this.dgS = z;
        if (this.dgR != null) {
            if (z) {
                this.dgR.au(4, 1);
            } else {
                this.dgR.ja(4);
            }
        }
    }

    public void b(h hVar) {
        this.dgR = hVar;
        fV(this.dgS);
    }

    public void aCI() {
        fV(true);
    }

    public void aCJ() {
        fV(false);
    }
}
