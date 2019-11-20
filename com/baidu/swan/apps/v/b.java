package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b aSs;
    private List<a> aSt = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean AR();

        boolean AS();
    }

    private b() {
    }

    public static b Km() {
        if (aSs == null) {
            synchronized (b.class) {
                if (aSs == null) {
                    aSs = new b();
                }
            }
        }
        return aSs;
    }

    public void a(a aVar) {
        if (aVar != null && !this.aSt.contains(aVar)) {
            this.aSt.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.aSt.remove(aVar);
        }
    }

    public void Kn() {
        for (a aVar : this.aSt) {
            if (aVar != null && aVar.AR()) {
                return;
            }
        }
    }

    public void Ko() {
        for (a aVar : this.aSt) {
            if (aVar != null && aVar.AS()) {
                return;
            }
        }
    }
}
