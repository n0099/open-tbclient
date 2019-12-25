package com.baidu.swan.games.p;

import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.menu.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.p;
/* loaded from: classes9.dex */
public final class a {
    private final ArrayList<Integer> clM = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            bG(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean bG(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f Uf = f.Uf();
                        p.i(Uf, "SwanAppController.getInstance()");
                        e DP = Uf.DP();
                        i iVar = DP != null ? (i) DP.p(i.class) : null;
                        h Me = iVar != null ? iVar.Me() : null;
                        if (Me != null && iVar != null) {
                            iVar.ck(true);
                        }
                        return a(Me, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(h hVar, String str) {
        Integer oY = b.oY(str);
        if (oY != null) {
            if (!this.clM.contains(oY)) {
                this.clM.add(oY);
            }
            if (hVar != null) {
                hVar.hY(oY.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(h hVar) {
        if (!this.clM.isEmpty()) {
            Iterator<Integer> it = this.clM.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    p.i(next, "id");
                    hVar.hY(next.intValue());
                }
            }
        }
    }
}
