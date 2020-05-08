package com.baidu.swan.game.ad.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cHI;
    private List<j> mCallbacks = new CopyOnWriteArrayList();

    public static a asS() {
        if (cHI == null) {
            synchronized (a.class) {
                if (cHI == null) {
                    cHI = new a();
                }
            }
        }
        return cHI;
    }

    public void a(j jVar) {
        if (jVar != null && !this.mCallbacks.contains(jVar)) {
            this.mCallbacks.add(jVar);
        }
    }

    public void W(int i, String str) {
        for (j jVar : this.mCallbacks) {
            if (i == 16) {
                jVar.atg();
            } else if (i == 17) {
                jVar.pj(str);
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
