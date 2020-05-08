package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction cRU;
    private JsFunction cRV;
    private JsFunction cRW;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.cRU = cVar.pR("onCheckForUpdate");
        if (bVar.cRU != null) {
            bVar.cRU.setReleaseMode(false);
        }
        bVar.cRV = cVar.pR("onUpdateReady");
        if (bVar.cRV != null) {
            bVar.cRV.setReleaseMode(false);
        }
        bVar.cRW = cVar.pR("onUpdateFailed");
        if (bVar.cRW != null) {
            bVar.cRW.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.cRU != null) {
            this.cRU.call(cVar);
        }
    }

    public void ayj() {
        if (this.cRV != null) {
            this.cRV.call();
        }
    }

    public void Xv() {
        if (this.cRW != null) {
            this.cRW.call();
        }
    }
}
