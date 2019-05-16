package com.baidu.swan.games.q.a.b;

import com.baidu.swan.menu.g;
/* loaded from: classes2.dex */
public class a {
    private g bka;
    private boolean bkb = true;

    private void cQ(boolean z) {
        this.bkb = z;
        if (this.bka != null) {
            if (z) {
                this.bka.J(4, 1);
            } else {
                this.bka.ft(4);
            }
        }
    }

    public void a(g gVar) {
        this.bka = gVar;
        cQ(this.bkb);
    }

    public void Sh() {
        cQ(true);
    }

    public void Si() {
        cQ(false);
    }
}
