package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.h;
/* loaded from: classes11.dex */
public class a {
    private h dce;
    private boolean dcf = true;

    private void fQ(boolean z) {
        this.dcf = z;
        if (this.dce != null) {
            if (z) {
                this.dce.as(4, 1);
            } else {
                this.dce.iP(4);
            }
        }
    }

    public void b(h hVar) {
        this.dce = hVar;
        fQ(this.dcf);
    }

    public void aBC() {
        fQ(true);
    }

    public void aBD() {
        fQ(false);
    }
}
