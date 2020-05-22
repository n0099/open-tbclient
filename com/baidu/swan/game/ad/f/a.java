package com.baidu.swan.game.ad.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cRS;
    private List<j> mCallbacks = new CopyOnWriteArrayList();

    public static a awz() {
        if (cRS == null) {
            synchronized (a.class) {
                if (cRS == null) {
                    cRS = new a();
                }
            }
        }
        return cRS;
    }

    public void a(j jVar) {
        if (jVar != null && !this.mCallbacks.contains(jVar)) {
            this.mCallbacks.add(jVar);
        }
    }

    public void X(int i, String str) {
        for (j jVar : this.mCallbacks) {
            if (i == 16) {
                jVar.awN();
            } else if (i == 17) {
                jVar.qH(str);
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
