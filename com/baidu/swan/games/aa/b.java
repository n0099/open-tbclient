package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes25.dex */
public class b {
    private JsFunction efe;
    private JsFunction eff;
    private JsFunction efg;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.efe = cVar.xg("onCheckForUpdate");
        if (bVar.efe != null) {
            bVar.efe.setReleaseMode(false);
        }
        bVar.eff = cVar.xg("onUpdateReady");
        if (bVar.eff != null) {
            bVar.eff.setReleaseMode(false);
        }
        bVar.efg = cVar.xg("onUpdateFailed");
        if (bVar.efg != null) {
            bVar.efg.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.efe != null) {
            this.efe.call(cVar);
        }
    }

    public void aZP() {
        if (this.eff != null) {
            this.eff.call();
        }
    }

    public void aZQ() {
        if (this.efg != null) {
            this.efg.call();
        }
    }
}
