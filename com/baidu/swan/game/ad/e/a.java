package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes19.dex */
public class a {
    private static volatile a dlW;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aJz() {
        if (dlW == null) {
            synchronized (a.class) {
                if (dlW == null) {
                    dlW = new a();
                }
            }
        }
        return dlW;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void Y(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.aJZ();
            } else if (i == 17) {
                kVar.ud(str);
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
