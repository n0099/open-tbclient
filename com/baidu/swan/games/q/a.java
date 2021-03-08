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
    private final ArrayList<Integer> ekr = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            de(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean de(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f aAo = f.aAo();
                        p.o(aAo, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f aga = aAo.aga();
                        j jVar = aga != null ? (j) aga.j(j.class) : null;
                        g aqb = jVar != null ? jVar.aqb() : null;
                        if (aqb != null && jVar != null) {
                            jVar.fr(true);
                        }
                        return a(aqb, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(g gVar, String str) {
        Integer xf = b.xf(str);
        if (xf != null) {
            if (!this.ekr.contains(xf)) {
                this.ekr.add(xf);
            }
            if (gVar != null) {
                gVar.lE(xf.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(g gVar) {
        if (!this.ekr.isEmpty()) {
            Iterator<Integer> it = this.ekr.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (gVar != null) {
                    p.o(next, "id");
                    gVar.lE(next.intValue());
                }
            }
        }
    }
}
