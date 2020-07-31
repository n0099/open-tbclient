package com.baidu.swan.games.q;

import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class a {
    private final ArrayList<Integer> dkG = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            cA(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean cA(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f akr = f.akr();
                        q.l((Object) akr, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f Sc = akr.Sc();
                        j jVar = Sc != null ? (j) Sc.q(j.class) : null;
                        com.baidu.swan.menu.h abB = jVar != null ? jVar.abB() : null;
                        if (abB != null && jVar != null) {
                            jVar.dR(true);
                        }
                        return a(abB, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer tm = b.tm(str);
        if (tm != null) {
            if (!this.dkG.contains(tm)) {
                this.dkG.add(tm);
            }
            if (hVar != null) {
                hVar.jr(tm.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.dkG.isEmpty()) {
            Iterator<Integer> it = this.dkG.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.l((Object) next, "id");
                    hVar.jr(next.intValue());
                }
            }
        }
    }
}
