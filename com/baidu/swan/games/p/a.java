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
    private final ArrayList<Integer> cPq = new ArrayList<>();

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
                        f aeJ = f.aeJ();
                        q.i(aeJ, "SwanAppController.getInstance()");
                        e Ot = aeJ.Ot();
                        i iVar = Ot != null ? (i) Ot.q(i.class) : null;
                        com.baidu.swan.menu.h WH = iVar != null ? iVar.WH() : null;
                        if (WH != null && iVar != null) {
                            iVar.dt(true);
                        }
                        return a(WH, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer qC = b.qC(str);
        if (qC != null) {
            if (!this.cPq.contains(qC)) {
                this.cPq.add(qC);
            }
            if (hVar != null) {
                hVar.iw(qC.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.cPq.isEmpty()) {
            Iterator<Integer> it = this.cPq.iterator();
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
