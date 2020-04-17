package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h cRd;
    private boolean cRe = true;

    private void fF(boolean z) {
        this.cRe = z;
        if (this.cRd != null) {
            if (z) {
                this.cRd.as(4, 1);
            } else {
                this.cRd.iw(4);
            }
        }
    }

    public void b(h hVar) {
        this.cRd = hVar;
        fF(this.cRe);
    }

    public void axL() {
        fF(true);
    }

    public void axM() {
        fF(false);
    }
}
