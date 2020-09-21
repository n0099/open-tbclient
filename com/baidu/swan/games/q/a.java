package com.baidu.swan.games.q;

import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes3.dex */
public final class a {
    private final ArrayList<Integer> dwS = new ArrayList<>();

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
                        f asJ = f.asJ();
                        q.l((Object) asJ, "SwanAppController.getInstance()");
                        com.baidu.swan.apps.core.d.f YG = asJ.YG();
                        j jVar = YG != null ? (j) YG.q(j.class) : null;
                        com.baidu.swan.menu.h aix = jVar != null ? jVar.aix() : null;
                        if (aix != null && jVar != null) {
                            jVar.ea(true);
                        }
                        return a(aix, str2);
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean a(com.baidu.swan.menu.h hVar, String str) {
        Integer vW = b.vW(str);
        if (vW != null) {
            if (!this.dwS.contains(vW)) {
                this.dwS.add(vW);
            }
            if (hVar != null) {
                hVar.lL(vW.intValue());
            }
            return true;
        }
        return false;
    }

    public final void a(com.baidu.swan.menu.h hVar) {
        if (!this.dwS.isEmpty()) {
            Iterator<Integer> it = this.dwS.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hVar != null) {
                    q.l((Object) next, "id");
                    hVar.lL(next.intValue());
                }
            }
        }
    }
}
