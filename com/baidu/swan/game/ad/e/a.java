package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes14.dex */
public class a {
    private static volatile a dOw;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aRn() {
        if (dOw == null) {
            synchronized (a.class) {
                if (dOw == null) {
                    dOw = new a();
                }
            }
        }
        return dOw;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void aq(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.aRN();
            } else if (i == 17) {
                kVar.vQ(str);
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
