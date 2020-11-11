package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public class b {
    private JsFunction dZN;
    private JsFunction dZO;
    private JsFunction dZP;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dZN = cVar.wE("onCheckForUpdate");
        if (bVar.dZN != null) {
            bVar.dZN.setReleaseMode(false);
        }
        bVar.dZO = cVar.wE("onUpdateReady");
        if (bVar.dZO != null) {
            bVar.dZO.setReleaseMode(false);
        }
        bVar.dZP = cVar.wE("onUpdateFailed");
        if (bVar.dZP != null) {
            bVar.dZP.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dZN != null) {
            this.dZN.call(cVar);
        }
    }

    public void aXs() {
        if (this.dZO != null) {
            this.dZO.call();
        }
    }

    public void aXt() {
        if (this.dZP != null) {
            this.dZP.call();
        }
    }
}
