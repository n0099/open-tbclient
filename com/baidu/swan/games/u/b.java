package com.baidu.swan.games.u;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bEQ;
    private JsFunction bER;
    private JsFunction bES;

    public static b i(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bEQ = cVar.jD("onCheckForUpdate");
        if (bVar.bEQ != null) {
            bVar.bEQ.setReleaseMode(false);
        }
        bVar.bER = cVar.jD("onUpdateReady");
        if (bVar.bER != null) {
            bVar.bER.setReleaseMode(false);
        }
        bVar.bES = cVar.jD("onUpdateFailed");
        if (bVar.bES != null) {
            bVar.bES.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bEQ != null) {
            this.bEQ.call(cVar);
        }
    }

    public void Yp() {
        if (this.bER != null) {
            this.bER.call();
        }
    }

    public void Yq() {
        if (this.bES != null) {
            this.bES.call();
        }
    }
}
