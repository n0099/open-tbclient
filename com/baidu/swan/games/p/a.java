package com.baidu.swan.games.p;

import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.binding.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class a {
    private final ArrayList<Integer> cPl = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            ca(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean ca(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f aeK = f.aeK();
                        q.i(aeK, "SwanAppController.getInstance()");
                        e Ou = aeK.Ou();
                        i iVar = Ou != null ? (i) Ou.q(i.class) : null;
                        com.baidu.swan.menu.h WI = iVar != null ? iVar.WI() : null;
                        if (WI != null && iVar != null) {
                            iVar.dt(true);
                        }
                        return a(WI, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer qC = b.qC(str);
        if (qC != null) {
            if (!this.cPl.contains(qC)) {
                this.cPl.add(qC);
            }
            if (hVar != null) {
                hVar.iw(qC.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.cPl.isEmpty()) {
            Iterator<Integer> it = this.cPl.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.i(next, "id");
                    hVar.iw(next.intValue());
                }
            }
        }
    }
}
