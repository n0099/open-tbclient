package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes7.dex */
public class b {
    private JsFunction dYf;
    private JsFunction dYg;
    private JsFunction dYh;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dYf = cVar.wz("onCheckForUpdate");
        if (bVar.dYf != null) {
            bVar.dYf.setReleaseMode(false);
        }
        bVar.dYg = cVar.wz("onUpdateReady");
        if (bVar.dYg != null) {
            bVar.dYg.setReleaseMode(false);
        }
        bVar.dYh = cVar.wz("onUpdateFailed");
        if (bVar.dYh != null) {
            bVar.dYh.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dYf != null) {
            this.dYf.call(cVar);
        }
    }

    public void aWK() {
        if (this.dYg != null) {
            this.dYg.call();
        }
    }

    public void aWL() {
        if (this.dYh != null) {
            this.dYh.call();
        }
    }
}
