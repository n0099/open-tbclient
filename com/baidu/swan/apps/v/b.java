package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b azw;
    private List<a> azx = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean vW();

        boolean vX();
    }

    private b() {
    }

    public static b Fr() {
        if (azw == null) {
            synchronized (b.class) {
                if (azw == null) {
                    azw = new b();
                }
            }
        }
        return azw;
    }

    public void a(a aVar) {
        if (aVar != null && !this.azx.contains(aVar)) {
            this.azx.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.azx.remove(aVar);
        }
    }

    public void Fs() {
        for (a aVar : this.azx) {
            if (aVar != null && aVar.vW()) {
                return;
            }
        }
    }

    public void Ft() {
        for (a aVar : this.azx) {
            if (aVar != null && aVar.vX()) {
                return;
            }
        }
    }
}
