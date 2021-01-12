package com.baidu.swan.games.u.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes8.dex */
public class a {
    private g eiC;
    private boolean eiD = true;

    /* renamed from: if  reason: not valid java name */
    private void m28if(boolean z) {
        this.eiD = z;
        if (this.eiC != null) {
            if (z) {
                this.eiC.aA(4, 1);
            } else {
                this.eiC.lA(4);
            }
        }
    }

    public void b(g gVar) {
        this.eiC = gVar;
        m28if(this.eiD);
    }

    public void aXS() {
        m28if(true);
    }

    public void aXT() {
        m28if(false);
    }
}
