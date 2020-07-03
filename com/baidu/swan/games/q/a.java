package com.baidu.swan.games.q;

import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.binding.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class a {
    private final ArrayList<Integer> deX = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            cx(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean cx(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f ajb = f.ajb();
                        q.l((Object) ajb, "SwanAppController.getInstance()");
                        e RN = ajb.RN();
                        i iVar = RN != null ? (i) RN.q(i.class) : null;
                        com.baidu.swan.menu.h aaz = iVar != null ? iVar.aaz() : null;
                        if (aaz != null && iVar != null) {
                            iVar.dN(true);
                        }
                        return a(aaz, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer sn = b.sn(str);
        if (sn != null) {
            if (!this.deX.contains(sn)) {
                this.deX.add(sn);
            }
            if (hVar != null) {
                hVar.ja(sn.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.deX.isEmpty()) {
            Iterator<Integer> it = this.deX.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.l((Object) next, "id");
                    hVar.ja(next.intValue());
                }
            }
        }
    }
}
