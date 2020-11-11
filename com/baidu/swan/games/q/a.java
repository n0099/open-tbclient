package com.baidu.swan.games.q;

import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class a {
    private final ArrayList<Integer> dXi = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            dg(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean dg(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f azO = f.azO();
                        q.m(azO, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f afM = azO.afM();
                        j jVar = afM != null ? (j) afM.q(j.class) : null;
                        com.baidu.swan.menu.h apD = jVar != null ? jVar.apD() : null;
                        if (apD != null && jVar != null) {
                            jVar.eS(true);
                        }
                        return a(apD, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer xp = b.xp(str);
        if (xp != null) {
            if (!this.dXi.contains(xp)) {
                this.dXi.add(xp);
            }
            if (hVar != null) {
                hVar.mD(xp.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.dXi.isEmpty()) {
            Iterator<Integer> it = this.dXi.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.m(next, "id");
                    hVar.mD(next.intValue());
                }
            }
        }
    }
}
