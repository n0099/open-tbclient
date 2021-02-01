package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes9.dex */
public class b {
    private JsFunction elA;
    private JsFunction ely;
    private JsFunction elz;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.ely = cVar.wn("onCheckForUpdate");
        if (bVar.ely != null) {
            bVar.ely.setReleaseMode(false);
        }
        bVar.elz = cVar.wn("onUpdateReady");
        if (bVar.elz != null) {
            bVar.elz.setReleaseMode(false);
        }
        bVar.elA = cVar.wn("onUpdateFailed");
        if (bVar.elA != null) {
            bVar.elA.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.ely != null) {
            this.ely.call(cVar);
        }
    }

    public void aYC() {
        if (this.elz != null) {
            this.elz.call();
        }
    }

    public void aYD() {
        if (this.elA != null) {
            this.elA.call();
        }
    }
}
