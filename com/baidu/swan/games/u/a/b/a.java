package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes3.dex */
public class a {
    private h dyK;
    private boolean dyL = true;

    private void gH(boolean z) {
        this.dyL = z;
        if (this.dyK != null) {
            if (z) {
                this.dyK.aB(4, 1);
            } else {
                this.dyK.lL(4);
            }
        }
    }

    public void b(h hVar) {
        this.dyK = hVar;
        gH(this.dyL);
    }

    public void aPR() {
        gH(true);
    }

    public void aPS() {
        gH(false);
    }
}
