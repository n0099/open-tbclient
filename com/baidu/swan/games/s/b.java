package com.baidu.swan.games.s;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bfD;
    private JsFunction bfE;
    private JsFunction bfF;

    public static b e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bfD = cVar.ii("onCheckForUpdate");
        if (bVar.bfD != null) {
            bVar.bfD.setReleaseMode(false);
        }
        bVar.bfE = cVar.ii("onUpdateReady");
        if (bVar.bfE != null) {
            bVar.bfE.setReleaseMode(false);
        }
        bVar.bfF = cVar.ii("onUpdateFailed");
        if (bVar.bfF != null) {
            bVar.bfF.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bfD != null) {
            this.bfD.call(cVar);
        }
    }

    public void Pi() {
        if (this.bfE != null) {
            this.bfE.call();
        }
    }

    public void Pj() {
        if (this.bfF != null) {
            this.bfF.call();
        }
    }
}
