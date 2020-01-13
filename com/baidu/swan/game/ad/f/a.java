package com.baidu.swan.game.ad.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    private static volatile a ceq;
    private List<j> mCallbacks = new CopyOnWriteArrayList();

    public static a ain() {
        if (ceq == null) {
            synchronized (a.class) {
                if (ceq == null) {
                    ceq = new a();
                }
            }
        }
        return ceq;
    }

    public void a(j jVar) {
        if (jVar != null && !this.mCallbacks.contains(jVar)) {
            this.mCallbacks.add(jVar);
        }
    }

    public void D(int i, String str) {
        for (j jVar : this.mCallbacks) {
            if (i == 16) {
                jVar.aiA();
            } else if (i == 17) {
                jVar.nG(str);
            }
            b(jVar);
        }
    }

    public void b(j jVar) {
        if (this.mCallbacks.contains(jVar)) {
            this.mCallbacks.remove(jVar);
        }
    }

    private a() {
    }
}
