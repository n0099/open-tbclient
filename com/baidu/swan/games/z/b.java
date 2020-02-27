package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public class b {
    private JsFunction csH;
    private JsFunction csI;
    private JsFunction csJ;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.csH = cVar.oF("onCheckForUpdate");
        if (bVar.csH != null) {
            bVar.csH.setReleaseMode(false);
        }
        bVar.csI = cVar.oF("onUpdateReady");
        if (bVar.csI != null) {
            bVar.csI.setReleaseMode(false);
        }
        bVar.csJ = cVar.oF("onUpdateFailed");
        if (bVar.csJ != null) {
            bVar.csJ.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.csH != null) {
            this.csH.call(cVar);
        }
    }

    public void apS() {
        if (this.csI != null) {
            this.csI.call();
        }
    }

    public void PC() {
        if (this.csJ != null) {
            this.csJ.call();
        }
    }
}
