package com.baidu.swan.games.p;

import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.binding.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes11.dex */
public final class a {
    private final ArrayList<Integer> cqp = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            bP(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean bP(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f WV = f.WV();
                        q.i(WV, "SwanAppController.getInstance()");
                        e GH = WV.GH();
                        i iVar = GH != null ? (i) GH.p(i.class) : null;
                        com.baidu.swan.menu.h OT = iVar != null ? iVar.OT() : null;
                        if (OT != null && iVar != null) {
                            iVar.cx(true);
                        }
                        return a(OT, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer pp = b.pp(str);
        if (pp != null) {
            if (!this.cqp.contains(pp)) {
                this.cqp.add(pp);
            }
            if (hVar != null) {
                hVar.ip(pp.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.cqp.isEmpty()) {
            Iterator<Integer> it = this.cqp.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.i(next, "id");
                    hVar.ip(next.intValue());
                }
            }
        }
    }
}
