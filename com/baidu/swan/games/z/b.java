package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction csI;
    private JsFunction csJ;
    private JsFunction csK;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.csI = cVar.oF("onCheckForUpdate");
        if (bVar.csI != null) {
            bVar.csI.setReleaseMode(false);
        }
        bVar.csJ = cVar.oF("onUpdateReady");
        if (bVar.csJ != null) {
            bVar.csJ.setReleaseMode(false);
        }
        bVar.csK = cVar.oF("onUpdateFailed");
        if (bVar.csK != null) {
            bVar.csK.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.csI != null) {
            this.csI.call(cVar);
        }
    }

    public void apU() {
        if (this.csJ != null) {
            this.csJ.call();
        }
    }

    public void PE() {
        if (this.csK != null) {
            this.csK.call();
        }
    }
}
