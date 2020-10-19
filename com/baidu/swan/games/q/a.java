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
    private final ArrayList<Integer> dIT = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            cZ(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean cZ(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f avu = f.avu();
                        q.m(avu, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f abs = avu.abs();
                        j jVar = abs != null ? (j) abs.q(j.class) : null;
                        com.baidu.swan.menu.h ali = jVar != null ? jVar.ali() : null;
                        if (ali != null && jVar != null) {
                            jVar.ew(true);
                        }
                        return a(ali, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer wI = b.wI(str);
        if (wI != null) {
            if (!this.dIT.contains(wI)) {
                this.dIT.add(wI);
            }
            if (hVar != null) {
                hVar.mi(wI.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.dIT.isEmpty()) {
            Iterator<Integer> it = this.dIT.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.m(next, "id");
                    hVar.mi(next.intValue());
                }
            }
        }
    }
}
