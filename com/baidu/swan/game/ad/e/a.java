package com.baidu.swan.game.ad.e;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {
    private static volatile a ecJ;
    private List<k> mCallbacks = new CopyOnWriteArrayList();

    public static a aWf() {
        if (ecJ == null) {
            synchronized (a.class) {
                if (ecJ == null) {
                    ecJ = new a();
                }
            }
        }
        return ecJ;
    }

    public void a(k kVar) {
        if (kVar != null && !this.mCallbacks.contains(kVar)) {
            this.mCallbacks.add(kVar);
        }
    }

    public void as(int i, String str) {
        for (k kVar : this.mCallbacks) {
            if (i == 16) {
                kVar.onLoadSuccess();
            } else if (i == 17) {
                kVar.wr(str);
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
