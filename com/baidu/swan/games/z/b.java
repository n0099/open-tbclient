package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction csJ;
    private JsFunction csK;
    private JsFunction csL;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.csJ = cVar.oF("onCheckForUpdate");
        if (bVar.csJ != null) {
            bVar.csJ.setReleaseMode(false);
        }
        bVar.csK = cVar.oF("onUpdateReady");
        if (bVar.csK != null) {
            bVar.csK.setReleaseMode(false);
        }
        bVar.csL = cVar.oF("onUpdateFailed");
        if (bVar.csL != null) {
            bVar.csL.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.csJ != null) {
            this.csJ.call(cVar);
        }
    }

    public void apU() {
        if (this.csK != null) {
            this.csK.call();
        }
    }

    public void PE() {
        if (this.csL != null) {
            this.csL.call();
        }
    }
}
