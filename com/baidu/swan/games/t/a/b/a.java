package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h crW;
    private boolean crX = true;

    private void eH(boolean z) {
        this.crX = z;
        if (this.crW != null) {
            if (z) {
                this.crW.ap(4, 1);
            } else {
                this.crW.ip(4);
            }
        }
    }

    public void b(h hVar) {
        this.crW = hVar;
        eH(this.crX);
    }

    public void apw() {
        eH(true);
    }

    public void apx() {
        eH(false);
    }
}
