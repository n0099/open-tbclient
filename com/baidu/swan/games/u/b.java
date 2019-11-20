package com.baidu.swan.games.u;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bDZ;
    private JsFunction bEa;
    private JsFunction bEb;

    public static b i(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bDZ = cVar.jD("onCheckForUpdate");
        if (bVar.bDZ != null) {
            bVar.bDZ.setReleaseMode(false);
        }
        bVar.bEa = cVar.jD("onUpdateReady");
        if (bVar.bEa != null) {
            bVar.bEa.setReleaseMode(false);
        }
        bVar.bEb = cVar.jD("onUpdateFailed");
        if (bVar.bEb != null) {
            bVar.bEb.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bDZ != null) {
            this.bDZ.call(cVar);
        }
    }

    public void Yn() {
        if (this.bEa != null) {
            this.bEa.call();
        }
    }

    public void Yo() {
        if (this.bEb != null) {
            this.bEb.call();
        }
    }
}
