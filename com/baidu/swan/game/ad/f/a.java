package com.baidu.swan.game.ad.f;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static volatile a ciH;
    private List<j> mCallbacks = new CopyOnWriteArrayList();

    public static a akG() {
        if (ciH == null) {
            synchronized (a.class) {
                if (ciH == null) {
                    ciH = new a();
                }
            }
        }
        return ciH;
    }

    public void a(j jVar) {
        if (jVar != null && !this.mCallbacks.contains(jVar)) {
            this.mCallbacks.add(jVar);
        }
    }

    public void F(int i, String str) {
        for (j jVar : this.mCallbacks) {
            if (i == 16) {
                jVar.akT();
            } else if (i == 17) {
                jVar.nU(str);
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
