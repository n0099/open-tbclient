package com.baidu.swan.games.p;

import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.binding.model.c;
import com.baidu.swan.menu.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.q;
/* loaded from: classes10.dex */
public final class a {
    private final ArrayList<Integer> clZ = new ArrayList<>();

    public final void i(c cVar) {
        if (cVar != null) {
            bH(cVar.optString("action"), cVar.optString("menuItemName"));
        }
    }

    private final boolean bH(String str, String str2) {
        if (str != null) {
            switch (str.hashCode()) {
                case 3202370:
                    if (str.equals("hide")) {
                        f UC = f.UC();
                        q.i(UC, "SwanAppController.getInstance()");
                        e El = UC.El();
                        i iVar = El != null ? (i) El.p(i.class) : null;
                        h MA = iVar != null ? iVar.MA() : null;
                        if (MA != null && iVar != null) {
                            iVar.cp(true);
                        }
                        return a(MA, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(h hVar, String str) {
        Integer pb = b.pb(str);
        if (pb != null) {
            if (!this.clZ.contains(pb)) {
                this.clZ.add(pb);
            }
            if (hVar != null) {
                hVar.hY(pb.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(h hVar) {
        if (!this.clZ.isEmpty()) {
            Iterator<Integer> it = this.clZ.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.i(next, "id");
                    hVar.hY(next.intValue());
                }
            }
        }
    }
}
