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
    private final ArrayList<Integer> cqe = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            bQ(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean bQ(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f WS = f.WS();
                        q.i(WS, "SwanAppController.getInstance()");
                        e GC = WS.GC();
                        i iVar = GC != null ? (i) GC.p(i.class) : null;
                        com.baidu.swan.menu.h OQ = iVar != null ? iVar.OQ() : null;
                        if (OQ != null && iVar != null) {
                            iVar.cw(true);
                        }
                        return a(OQ, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer pq = b.pq(str);
        if (pq != null) {
            if (!this.cqe.contains(pq)) {
                this.cqe.add(pq);
            }
            if (hVar != null) {
                hVar.ip(pq.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.cqe.isEmpty()) {
            Iterator<Integer> it = this.cqe.iterator();
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
