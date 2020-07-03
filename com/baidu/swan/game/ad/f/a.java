package com.baidu.swan.game.ad.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cWC;
    private List<j> mCallbacks = new CopyOnWriteArrayList();

    public static a axF() {
        if (cWC == null) {
            synchronized (a.class) {
                if (cWC == null) {
                    cWC = new a();
                }
            }
        }
        return cWC;
    }

    public void a(j jVar) {
        if (jVar != null && !this.mCallbacks.contains(jVar)) {
            this.mCallbacks.add(jVar);
        }
    }

    public void Z(int i, String str) {
        for (j jVar : this.mCallbacks) {
            if (i == 16) {
                jVar.axT();
            } else if (i == 17) {
                jVar.qP(str);
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
