package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b aSK;
    private List<a> aSL = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean AQ();

        boolean AR();
    }

    private b() {
    }

    public static b Kl() {
        if (aSK == null) {
            synchronized (b.class) {
                if (aSK == null) {
                    aSK = new b();
                }
            }
        }
        return aSK;
    }

    public void a(a aVar) {
        if (aVar != null && !this.aSL.contains(aVar)) {
            this.aSL.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.aSL.remove(aVar);
        }
    }

    public void Km() {
        for (a aVar : this.aSL) {
            if (aVar != null && aVar.AQ()) {
                return;
            }
        }
    }

    public void Kn() {
        for (a aVar : this.aSL) {
            if (aVar != null && aVar.AR()) {
                return;
            }
        }
    }
}
