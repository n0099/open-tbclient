package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction cRP;
    private JsFunction cRQ;
    private JsFunction cRR;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.cRP = cVar.pR("onCheckForUpdate");
        if (bVar.cRP != null) {
            bVar.cRP.setReleaseMode(false);
        }
        bVar.cRQ = cVar.pR("onUpdateReady");
        if (bVar.cRQ != null) {
            bVar.cRQ.setReleaseMode(false);
        }
        bVar.cRR = cVar.pR("onUpdateFailed");
        if (bVar.cRR != null) {
            bVar.cRR.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.cRP != null) {
            this.cRP.call(cVar);
        }
    }

    public void ayj() {
        if (this.cRQ != null) {
            this.cRQ.call();
        }
    }

    public void Xw() {
        if (this.cRR != null) {
            this.cRR.call();
        }
    }
}
