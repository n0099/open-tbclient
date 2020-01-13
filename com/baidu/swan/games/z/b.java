package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public class b {
    private JsFunction coG;
    private JsFunction coH;
    private JsFunction coI;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.coG = cVar.oq("onCheckForUpdate");
        if (bVar.coG != null) {
            bVar.coG.setReleaseMode(false);
        }
        bVar.coH = cVar.oq("onUpdateReady");
        if (bVar.coH != null) {
            bVar.coH.setReleaseMode(false);
        }
        bVar.coI = cVar.oq("onUpdateFailed");
        if (bVar.coI != null) {
            bVar.coI.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.coG != null) {
            this.coG.call(cVar);
        }
    }

    public void anE() {
        if (this.coH != null) {
            this.coH.call();
        }
    }

    public void No() {
        if (this.coI != null) {
            this.coI.call();
        }
    }
}
