package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes25.dex */
public class a {
    private h eer;
    private boolean ees = true;

    private void hR(boolean z) {
        this.ees = z;
        if (this.eer != null) {
            if (z) {
                this.eer.aD(4, 1);
            } else {
                this.eer.mX(4);
            }
        }
    }

    public void b(h hVar) {
        this.eer = hVar;
        hR(this.ees);
    }

    public void aZr() {
        hR(true);
    }

    public void aZs() {
        hR(false);
    }
}
