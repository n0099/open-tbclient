package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes7.dex */
public class a {
    private h dXs;
    private boolean dXt = true;

    private void hC(boolean z) {
        this.dXt = z;
        if (this.dXs != null) {
            if (z) {
                this.dXs.aB(4, 1);
            } else {
                this.dXs.mz(4);
            }
        }
    }

    public void b(h hVar) {
        this.dXs = hVar;
        hC(this.dXt);
    }

    public void aWm() {
        hC(true);
    }

    public void aWn() {
        hC(false);
    }
}
