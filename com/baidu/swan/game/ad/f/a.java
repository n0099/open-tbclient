package com.baidu.swan.game.ad.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class a {
    private static volatile a ced;
    private List<j> mCallbacks = new CopyOnWriteArrayList();

    public static a ahU() {
        if (ced == null) {
            synchronized (a.class) {
                if (ced == null) {
                    ced = new a();
                }
            }
        }
        return ced;
    }

    public void a(j jVar) {
        if (jVar != null && !this.mCallbacks.contains(jVar)) {
            this.mCallbacks.add(jVar);
        }
    }

    public void B(int i, String str) {
        for (j jVar : this.mCallbacks) {
            if (i == 16) {
                jVar.aih();
            } else if (i == 17) {
                jVar.nD(str);
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
