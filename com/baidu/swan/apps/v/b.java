package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b ayY;
    private List<a> ayZ = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean vS();

        boolean vT();
    }

    private b() {
    }

    public static b Fn() {
        if (ayY == null) {
            synchronized (b.class) {
                if (ayY == null) {
                    ayY = new b();
                }
            }
        }
        return ayY;
    }

    public void a(a aVar) {
        if (aVar != null && !this.ayZ.contains(aVar)) {
            this.ayZ.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ayZ.remove(aVar);
        }
    }

    public void Fo() {
        for (a aVar : this.ayZ) {
            if (aVar != null && aVar.vS()) {
                return;
            }
        }
    }

    public void Fp() {
        for (a aVar : this.ayZ) {
            if (aVar != null && aVar.vT()) {
                return;
            }
        }
    }
}
