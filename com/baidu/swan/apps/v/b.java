package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b axD;
    private List<a> axE = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean uH();

        boolean uI();
    }

    private b() {
    }

    public static b Dv() {
        if (axD == null) {
            synchronized (b.class) {
                if (axD == null) {
                    axD = new b();
                }
            }
        }
        return axD;
    }

    public void a(a aVar) {
        if (aVar != null && !this.axE.contains(aVar)) {
            this.axE.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.axE.remove(aVar);
        }
    }

    public void Dw() {
        for (a aVar : this.axE) {
            if (aVar != null && aVar.uH()) {
                return;
            }
        }
    }

    public void Dx() {
        for (a aVar : this.axE) {
            if (aVar != null && aVar.uI()) {
                return;
            }
        }
    }
}
