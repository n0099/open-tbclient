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
    private final ArrayList<Integer> dai = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            cv(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean cv(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f ahV = f.ahV();
                        q.l((Object) ahV, "SwanAppController.getInstance()");
                        e QH = ahV.QH();
                        i iVar = QH != null ? (i) QH.q(i.class) : null;
                        com.baidu.swan.menu.h Zt = iVar != null ? iVar.Zt() : null;
                        if (Zt != null && iVar != null) {
                            iVar.dI(true);
                        }
                        return a(Zt, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer sf = b.sf(str);
        if (sf != null) {
            if (!this.dai.contains(sf)) {
                this.dai.add(sf);
            }
            if (hVar != null) {
                hVar.iP(sf.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.dai.isEmpty()) {
            Iterator<Integer> it = this.dai.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.l((Object) next, "id");
                    hVar.iP(next.intValue());
                }
            }
        }
    }
}
