package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class a {
    private static volatile a dbK;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aAQ() {
        if (dbK == null) {
            synchronized (a.class) {
                if (dbK == null) {
                    dbK = new a();
                }
            }
        }
        return dbK;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void aa(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.aBj();
            } else if (i == 17) {
                kVar.rL(str);
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
