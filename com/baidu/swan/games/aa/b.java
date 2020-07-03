package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction dhE;
    private JsFunction dhF;
    private JsFunction dhG;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dhE = cVar.rB("onCheckForUpdate");
        if (bVar.dhE != null) {
            bVar.dhE.setReleaseMode(false);
        }
        bVar.dhF = cVar.rB("onUpdateReady");
        if (bVar.dhF != null) {
            bVar.dhF.setReleaseMode(false);
        }
        bVar.dhG = cVar.rB("onUpdateFailed");
        if (bVar.dhG != null) {
            bVar.dhG.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dhE != null) {
            this.dhE.call(cVar);
        }
    }

    public void aDg() {
        if (this.dhF != null) {
            this.dhF.call();
        }
    }

    public void aDh() {
        if (this.dhG != null) {
            this.dhG.call();
        }
    }
}
