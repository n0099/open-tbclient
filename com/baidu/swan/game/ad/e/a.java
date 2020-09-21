package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    private static volatile a dod;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aKk() {
        if (dod == null) {
            synchronized (a.class) {
                if (dod == null) {
                    dod = new a();
                }
            }
        }
        return dod;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void Z(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.aKK();
            } else if (i == 17) {
                kVar.ux(str);
            }
            b(kVar);
        }
    }

    public void b(k kVar) {
        if (this.mCallbacks.contains(kVar)) {
            this.mCallbacks.remove(kVar);
        }
    }

    private a() {
    }
}
