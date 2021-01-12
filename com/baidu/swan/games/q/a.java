package com.baidu.swan.games.q;

import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.menu.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes8.dex */
public final class a {
    private final ArrayList<Integer> egJ = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            dk(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean dk(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f azN = f.azN();
                        p.n(azN, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f afz = azN.afz();
                        j jVar = afz != null ? (j) afz.j(j.class) : null;
                        g apA = jVar != null ? jVar.apA() : null;
                        if (apA != null && jVar != null) {
                            jVar.fp(true);
                        }
                        return a(apA, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(g gVar, String str) {
        Integer wF = b.wF(str);
        if (wF != null) {
            if (!this.egJ.contains(wF)) {
                this.egJ.add(wF);
            }
            if (gVar != null) {
                gVar.lA(wF.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(g gVar) {
        if (!this.egJ.isEmpty()) {
            Iterator<Integer> it = this.egJ.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (gVar != null) {
                    p.n(next, "id");
                    gVar.lA(next.intValue());
                }
            }
        }
    }
}
