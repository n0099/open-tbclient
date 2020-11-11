package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes10.dex */
public class a {
    private h dZa;
    private boolean dZb = true;

    private void hz(boolean z) {
        this.dZb = z;
        if (this.dZa != null) {
            if (z) {
                this.dZa.aB(4, 1);
            } else {
                this.dZa.mD(4);
            }
        }
    }

    public void b(h hVar) {
        this.dZa = hVar;
        hz(this.dZb);
    }

    public void aWU() {
        hz(true);
    }

    public void aWV() {
        hz(false);
    }
}
