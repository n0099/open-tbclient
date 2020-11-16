package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes12.dex */
public class a {
    private static volatile a dMO;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aQF() {
        if (dMO == null) {
            synchronized (a.class) {
                if (dMO == null) {
                    dMO = new a();
                }
            }
        }
        return dMO;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void aq(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.aRf();
            } else if (i == 17) {
                kVar.vL(str);
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
