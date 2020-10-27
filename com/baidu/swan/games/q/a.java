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
    private final ArrayList<Integer> dRq = new ArrayList<>();

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
                        f axo = f.axo();
                        q.m(axo, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f adm = axo.adm();
                        j jVar = adm != null ? (j) adm.q(j.class) : null;
                        com.baidu.swan.menu.h anc = jVar != null ? jVar.anc() : null;
                        if (anc != null && jVar != null) {
                            jVar.eJ(true);
                        }
                        return a(anc, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer xb = b.xb(str);
        if (xb != null) {
            if (!this.dRq.contains(xb)) {
                this.dRq.add(xb);
            }
            if (hVar != null) {
                hVar.mt(xb.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.dRq.isEmpty()) {
            Iterator<Integer> it = this.dRq.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.m(next, "id");
                    hVar.mt(next.intValue());
                }
            }
        }
    }
}
