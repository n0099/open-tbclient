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
/* loaded from: classes9.dex */
public final class a {
    private final ArrayList<Integer> elv = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            dl(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean dl(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f aDG = f.aDG();
                        p.n(aDG, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f ajs = aDG.ajs();
                        j jVar = ajs != null ? (j) ajs.j(j.class) : null;
                        g atu = jVar != null ? jVar.atu() : null;
                        if (atu != null && jVar != null) {
                            jVar.ft(true);
                        }
                        return a(atu, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(g gVar, String str) {
        Integer xQ = b.xQ(str);
        if (xQ != null) {
            if (!this.elv.contains(xQ)) {
                this.elv.add(xQ);
            }
            if (gVar != null) {
                gVar.ng(xQ.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(g gVar) {
        if (!this.elv.isEmpty()) {
            Iterator<Integer> it = this.elv.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (gVar != null) {
                    p.n(next, "id");
                    gVar.ng(next.intValue());
                }
            }
        }
    }
}
