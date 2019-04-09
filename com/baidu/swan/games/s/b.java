package com.baidu.swan.games.s;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bfE;
    private JsFunction bfF;
    private JsFunction bfG;

    public static b e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bfE = cVar.ii("onCheckForUpdate");
        if (bVar.bfE != null) {
            bVar.bfE.setReleaseMode(false);
        }
        bVar.bfF = cVar.ii("onUpdateReady");
        if (bVar.bfF != null) {
            bVar.bfF.setReleaseMode(false);
        }
        bVar.bfG = cVar.ii("onUpdateFailed");
        if (bVar.bfG != null) {
            bVar.bfG.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bfE != null) {
            this.bfE.call(cVar);
        }
    }

    public void Pi() {
        if (this.bfF != null) {
            this.bfF.call();
        }
    }

    public void Pj() {
        if (this.bfG != null) {
            this.bfG.call();
        }
    }
}
