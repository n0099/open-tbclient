package com.baidu.swan.games.t.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h csi;
    private boolean csj = true;

    private void eI(boolean z) {
        this.csj = z;
        if (this.csi != null) {
            if (z) {
                this.csi.ap(4, 1);
            } else {
                this.csi.ip(4);
            }
        }
    }

    public void b(h hVar) {
        this.csi = hVar;
        eI(this.csj);
    }

    public void apz() {
        eI(true);
    }

    public void apA() {
        eI(false);
    }
}
