package com.baidu.swan.games.q;

import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes8.dex */
public final class a {
    private final ArrayList<Integer> duN = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            cU(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean cU(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f arY = f.arY();
                        q.l((Object) arY, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f XX = arY.XX();
                        j jVar = XX != null ? (j) XX.q(j.class) : null;
                        com.baidu.swan.menu.h ahN = jVar != null ? jVar.ahN() : null;
                        if (ahN != null && jVar != null) {
                            jVar.eb(true);
                        }
                        return a(ahN, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer vC = b.vC(str);
        if (vC != null) {
            if (!this.duN.contains(vC)) {
                this.duN.add(vC);
            }
            if (hVar != null) {
                hVar.lA(vC.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.duN.isEmpty()) {
            Iterator<Integer> it = this.duN.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.l((Object) next, "id");
                    hVar.lA(next.intValue());
                }
            }
        }
    }
}
