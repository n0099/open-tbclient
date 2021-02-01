package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes9.dex */
public class a {
    private g ekJ;
    private boolean ekK = true;

    private void ih(boolean z) {
        this.ekK = z;
        if (this.ekJ != null) {
            if (z) {
                this.ekJ.ax(4, 1);
            } else {
                this.ekJ.lD(4);
            }
        }
    }

    public void b(g gVar) {
        this.ekJ = gVar;
        ih(this.ekK);
    }

    public void aYe() {
        ih(true);
    }

    public void aYf() {
        ih(false);
    }
}
