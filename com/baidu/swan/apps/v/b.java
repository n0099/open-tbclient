package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b axy;
    private List<a> axz = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean uI();

        boolean uJ();
    }

    private b() {
    }

    public static b Dx() {
        if (axy == null) {
            synchronized (b.class) {
                if (axy == null) {
                    axy = new b();
                }
            }
        }
        return axy;
    }

    public void a(a aVar) {
        if (aVar != null && !this.axz.contains(aVar)) {
            this.axz.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.axz.remove(aVar);
        }
    }

    public void Dy() {
        for (a aVar : this.axz) {
            if (aVar != null && aVar.uI()) {
                return;
            }
        }
    }

    public void Dz() {
        for (a aVar : this.axz) {
            if (aVar != null && aVar.uJ()) {
                return;
            }
        }
    }
}
