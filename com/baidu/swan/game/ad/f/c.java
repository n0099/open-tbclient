package com.baidu.swan.game.ad.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class c {
    private static volatile c bwI;
    private List<k> b = new CopyOnWriteArrayList();

    public static c VD() {
        if (bwI == null) {
            synchronized (c.class) {
                if (bwI == null) {
                    bwI = new c();
                }
            }
        }
        return bwI;
    }

    public void a(k kVar) {
        if (kVar != null && !this.b.contains(kVar)) {
            this.b.add(kVar);
        }
    }

    public void a(int i, String str) {
        for (k kVar : this.b) {
            if (i == 16) {
                kVar.a();
            } else if (i == 17) {
                kVar.a(str);
            }
            b(kVar);
        }
    }

    public void b(k kVar) {
        if (this.b.contains(kVar)) {
            this.b.remove(kVar);
        }
    }

    private c() {
    }
}
