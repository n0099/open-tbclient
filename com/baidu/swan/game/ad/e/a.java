package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes14.dex */
public class a {
    private static volatile a dXX;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aSl() {
        if (dXX == null) {
            synchronized (a.class) {
                if (dXX == null) {
                    dXX = new a();
                }
            }
        }
        return dXX;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void at(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.onLoadSuccess();
            } else if (i == 17) {
                kVar.vg(str);
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
