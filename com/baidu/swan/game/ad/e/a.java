package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes14.dex */
public class a {
    private static volatile a dIE;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aON() {
        if (dIE == null) {
            synchronized (a.class) {
                if (dIE == null) {
                    dIE = new a();
                }
            }
        }
        return dIE;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void am(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.aPn();
            } else if (i == 17) {
                kVar.vC(str);
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
