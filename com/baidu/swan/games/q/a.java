package com.baidu.swan.games.q;

import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.menu.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes25.dex */
public final class a {
    private final ArrayList<Integer> ecy = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            dm(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean dm(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f aCp = f.aCp();
                        p.n(aCp, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f aim = aCp.aim();
                        j jVar = aim != null ? (j) aim.q(j.class) : null;
                        h asc = jVar != null ? jVar.asc() : null;
                        if (asc != null && jVar != null) {
                            jVar.fk(true);
                        }
                        return a(asc, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(h hVar, String str) {
        Integer xR = b.xR(str);
        if (xR != null) {
            if (!this.ecy.contains(xR)) {
                this.ecy.add(xR);
            }
            if (hVar != null) {
                hVar.mX(xR.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(h hVar) {
        if (!this.ecy.isEmpty()) {
            Iterator<Integer> it = this.ecy.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    p.n(next, "id");
                    hVar.mX(next.intValue());
                }
            }
        }
    }
}
