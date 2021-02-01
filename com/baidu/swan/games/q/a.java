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
    private final ArrayList<Integer> eiQ = new ArrayList<>();

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
                        f aAl = f.aAl();
                        p.n(aAl, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f afX = aAl.afX();
                        j jVar = afX != null ? (j) afX.j(j.class) : null;
                        g apY = jVar != null ? jVar.apY() : null;
                        if (apY != null && jVar != null) {
                            jVar.fr(true);
                        }
                        return a(apY, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(g gVar, String str) {
        Integer wY = b.wY(str);
        if (wY != null) {
            if (!this.eiQ.contains(wY)) {
                this.eiQ.add(wY);
            }
            if (gVar != null) {
                gVar.lD(wY.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(g gVar) {
        if (!this.eiQ.isEmpty()) {
            Iterator<Integer> it = this.eiQ.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (gVar != null) {
                    p.n(next, "id");
                    gVar.lD(next.intValue());
                }
            }
        }
    }
}
