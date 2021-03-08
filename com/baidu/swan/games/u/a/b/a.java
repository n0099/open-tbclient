package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes8.dex */
public class a {
    private g emk;
    private boolean eml = true;

    private void ih(boolean z) {
        this.eml = z;
        if (this.emk != null) {
            if (z) {
                this.emk.ax(4, 1);
            } else {
                this.emk.lE(4);
            }
        }
    }

    public void b(g gVar) {
        this.emk = gVar;
        ih(this.eml);
    }

    public void aYh() {
        ih(true);
    }

    public void aYi() {
        ih(false);
    }
}
