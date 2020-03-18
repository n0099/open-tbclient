package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction csU;
    private JsFunction csV;
    private JsFunction csW;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.csU = cVar.oE("onCheckForUpdate");
        if (bVar.csU != null) {
            bVar.csU.setReleaseMode(false);
        }
        bVar.csV = cVar.oE("onUpdateReady");
        if (bVar.csV != null) {
            bVar.csV.setReleaseMode(false);
        }
        bVar.csW = cVar.oE("onUpdateFailed");
        if (bVar.csW != null) {
            bVar.csW.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.csU != null) {
            this.csU.call(cVar);
        }
    }

    public void apX() {
        if (this.csV != null) {
            this.csV.call();
        }
    }

    public void PH() {
        if (this.csW != null) {
            this.csW.call();
        }
    }
}
