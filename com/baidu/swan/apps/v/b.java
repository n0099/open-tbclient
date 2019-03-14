package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b axz;
    private List<a> axA = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean uI();

        boolean uJ();
    }

    private b() {
    }

    public static b Dx() {
        if (axz == null) {
            synchronized (b.class) {
                if (axz == null) {
                    axz = new b();
                }
            }
        }
        return axz;
    }

    public void a(a aVar) {
        if (aVar != null && !this.axA.contains(aVar)) {
            this.axA.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.axA.remove(aVar);
        }
    }

    public void Dy() {
        for (a aVar : this.axA) {
            if (aVar != null && aVar.uI()) {
                return;
            }
        }
    }

    public void Dz() {
        for (a aVar : this.axA) {
            if (aVar != null && aVar.uJ()) {
                return;
            }
        }
    }
}
