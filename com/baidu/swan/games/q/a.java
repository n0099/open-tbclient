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
    private final ArrayList<Integer> dVA = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            df(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean df(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f azg = f.azg();
                        q.m(azg, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f afe = azg.afe();
                        j jVar = afe != null ? (j) afe.q(j.class) : null;
                        com.baidu.swan.menu.h aoU = jVar != null ? jVar.aoU() : null;
                        if (aoU != null && jVar != null) {
                            jVar.eV(true);
                        }
                        return a(aoU, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer xk = b.xk(str);
        if (xk != null) {
            if (!this.dVA.contains(xk)) {
                this.dVA.add(xk);
            }
            if (hVar != null) {
                hVar.mz(xk.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.dVA.isEmpty()) {
            Iterator<Integer> it = this.dVA.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.m(next, "id");
                    hVar.mz(next.intValue());
                }
            }
        }
    }
}
