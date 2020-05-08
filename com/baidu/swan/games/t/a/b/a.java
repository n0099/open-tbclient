package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h cRi;
    private boolean cRj = true;

    private void fF(boolean z) {
        this.cRj = z;
        if (this.cRi != null) {
            if (z) {
                this.cRi.as(4, 1);
            } else {
                this.cRi.iw(4);
            }
        }
    }

    public void b(h hVar) {
        this.cRi = hVar;
        fF(this.cRj);
    }

    public void axL() {
        fF(true);
    }

    public void axM() {
        fF(false);
    }
}
