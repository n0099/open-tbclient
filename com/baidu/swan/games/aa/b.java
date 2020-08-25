package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public class b {
    private JsFunction dxs;
    private JsFunction dxt;
    private JsFunction dxu;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dxs = cVar.uR("onCheckForUpdate");
        if (bVar.dxs != null) {
            bVar.dxs.setReleaseMode(false);
        }
        bVar.dxt = cVar.uR("onUpdateReady");
        if (bVar.dxt != null) {
            bVar.dxt.setReleaseMode(false);
        }
        bVar.dxu = cVar.uR("onUpdateFailed");
        if (bVar.dxu != null) {
            bVar.dxu.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dxs != null) {
            this.dxs.call(cVar);
        }
    }

    public void aPE() {
        if (this.dxt != null) {
            this.dxt.call();
        }
    }

    public void aPF() {
        if (this.dxu != null) {
            this.dxu.call();
        }
    }
}
