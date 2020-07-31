package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes7.dex */
public class a {
    private h dmA;
    private boolean dmB = true;

    private void gm(boolean z) {
        this.dmB = z;
        if (this.dmA != null) {
            if (z) {
                this.dmA.au(4, 1);
            } else {
                this.dmA.jr(4);
            }
        }
    }

    public void b(h hVar) {
        this.dmA = hVar;
        gm(this.dmB);
    }

    public void aGp() {
        gm(true);
    }

    public void aGq() {
        gm(false);
    }
}
