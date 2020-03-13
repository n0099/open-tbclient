package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h crX;
    private boolean crY = true;

    private void eH(boolean z) {
        this.crY = z;
        if (this.crX != null) {
            if (z) {
                this.crX.ap(4, 1);
            } else {
                this.crX.ip(4);
            }
        }
    }

    public void b(h hVar) {
        this.crX = hVar;
        eH(this.crY);
    }

    public void apw() {
        eH(true);
    }

    public void apx() {
        eH(false);
    }
}
