package com.baidu.swan.games.u;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction blF;
    private JsFunction blG;
    private JsFunction blH;

    public static b i(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.blF = cVar.iY("onCheckForUpdate");
        if (bVar.blF != null) {
            bVar.blF.setReleaseMode(false);
        }
        bVar.blG = cVar.iY("onUpdateReady");
        if (bVar.blG != null) {
            bVar.blG.setReleaseMode(false);
        }
        bVar.blH = cVar.iY("onUpdateFailed");
        if (bVar.blH != null) {
            bVar.blH.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.blF != null) {
            this.blF.call(cVar);
        }
    }

    public void Tu() {
        if (this.blG != null) {
            this.blG.call();
        }
    }

    public void Tv() {
        if (this.blH != null) {
            this.blH.call();
        }
    }
}
