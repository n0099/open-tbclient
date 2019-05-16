package com.baidu.swan.apps.v;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static volatile b ayr;
    private List<a> ays = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        boolean vr();

        boolean vs();
    }

    private b() {
    }

    public static b ED() {
        if (ayr == null) {
            synchronized (b.class) {
                if (ayr == null) {
                    ayr = new b();
                }
            }
        }
        return ayr;
    }

    public void a(a aVar) {
        if (aVar != null && !this.ays.contains(aVar)) {
            this.ays.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ays.remove(aVar);
        }
    }

    public void EE() {
        for (a aVar : this.ays) {
            if (aVar != null && aVar.vr()) {
                return;
            }
        }
    }

    public void EF() {
        for (a aVar : this.ays) {
            if (aVar != null && aVar.vs()) {
                return;
            }
        }
    }
}
