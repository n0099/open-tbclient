package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public class b {
    private JsFunction dLA;
    private JsFunction dLy;
    private JsFunction dLz;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dLy = cVar.vX("onCheckForUpdate");
        if (bVar.dLy != null) {
            bVar.dLy.setReleaseMode(false);
        }
        bVar.dLz = cVar.vX("onUpdateReady");
        if (bVar.dLz != null) {
            bVar.dLz.setReleaseMode(false);
        }
        bVar.dLA = cVar.vX("onUpdateFailed");
        if (bVar.dLA != null) {
            bVar.dLA.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dLy != null) {
            this.dLy.call(cVar);
        }
    }

    public void aSY() {
        if (this.dLz != null) {
            this.dLz.call();
        }
    }

    public void aSZ() {
        if (this.dLA != null) {
            this.dLA.call();
        }
    }
}
