package com.baidu.swan.games.q.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes2.dex */
public class a {
    private g bll;
    private boolean blm = true;

    private void cT(boolean z) {
        this.blm = z;
        if (this.bll != null) {
            if (z) {
                this.bll.M(4, 1);
            } else {
                this.bll.fy(4);
            }
        }
    }

    public void a(g gVar) {
        this.bll = gVar;
        cT(this.blm);
    }

    public void Te() {
        cT(true);
    }

    public void Tf() {
        cT(false);
    }
}
