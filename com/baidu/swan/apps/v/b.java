package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b axC;
    private List<a> axD = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean uH();

        boolean uI();
    }

    private b() {
    }

    public static b Dv() {
        if (axC == null) {
            synchronized (b.class) {
                if (axC == null) {
                    axC = new b();
                }
            }
        }
        return axC;
    }

    public void a(a aVar) {
        if (aVar != null && !this.axD.contains(aVar)) {
            this.axD.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.axD.remove(aVar);
        }
    }

    public void Dw() {
        for (a aVar : this.axD) {
            if (aVar != null && aVar.uH()) {
                return;
            }
        }
    }

    public void Dx() {
        for (a aVar : this.axD) {
            if (aVar != null && aVar.uI()) {
                return;
            }
        }
    }
}
