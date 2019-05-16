package com.baidu.swan.games.u;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bkS;
    private JsFunction bkT;
    private JsFunction bkU;

    public static b i(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bkS = cVar.iR("onCheckForUpdate");
        if (bVar.bkS != null) {
            bVar.bkS.setReleaseMode(false);
        }
        bVar.bkT = cVar.iR("onUpdateReady");
        if (bVar.bkT != null) {
            bVar.bkT.setReleaseMode(false);
        }
        bVar.bkU = cVar.iR("onUpdateFailed");
        if (bVar.bkU != null) {
            bVar.bkU.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bkS != null) {
            this.bkS.call(cVar);
        }
    }

    public void SB() {
        if (this.bkT != null) {
            this.bkT.call();
        }
    }

    public void SC() {
        if (this.bkU != null) {
            this.bkU.call();
        }
    }
}
