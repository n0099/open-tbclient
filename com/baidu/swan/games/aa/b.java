package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction dcS;
    private JsFunction dcT;
    private JsFunction dcU;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dcS = cVar.rt("onCheckForUpdate");
        if (bVar.dcS != null) {
            bVar.dcS.setReleaseMode(false);
        }
        bVar.dcT = cVar.rt("onUpdateReady");
        if (bVar.dcT != null) {
            bVar.dcT.setReleaseMode(false);
        }
        bVar.dcU = cVar.rt("onUpdateFailed");
        if (bVar.dcU != null) {
            bVar.dcU.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dcS != null) {
            this.dcS.call(cVar);
        }
    }

    public void aCa() {
        if (this.dcT != null) {
            this.dcT.call();
        }
    }

    public void aCb() {
        if (this.dcU != null) {
            this.dcU.call();
        }
    }
}
