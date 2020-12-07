package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes14.dex */
public class a {
    private static volatile a dTM;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aTK() {
        if (dTM == null) {
            synchronized (a.class) {
                if (dTM == null) {
                    dTM = new a();
                }
            }
        }
        return dTM;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void aq(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.aUk();
            } else if (i == 17) {
                kVar.ws(str);
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
