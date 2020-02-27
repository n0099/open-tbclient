package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h crV;
    private boolean crW = true;

    private void eH(boolean z) {
        this.crW = z;
        if (this.crV != null) {
            if (z) {
                this.crV.ap(4, 1);
            } else {
                this.crV.ip(4);
            }
        }
    }

    public void b(h hVar) {
        this.crV = hVar;
        eH(this.crW);
    }

    public void apu() {
        eH(true);
    }

    public void apv() {
        eH(false);
    }
}
