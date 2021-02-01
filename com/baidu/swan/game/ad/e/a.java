package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public class a {
    private static volatile a ead;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aSx() {
        if (ead == null) {
            synchronized (a.class) {
                if (ead == null) {
                    ead = new a();
                }
            }
        }
        return ead;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void ax(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.onLoadSuccess();
            } else if (i == 17) {
                kVar.vz(str);
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
