package com.baidu.swan.games.s;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bfA;
    private JsFunction bfB;
    private JsFunction bfC;

    public static b e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bfA = cVar.ih("onCheckForUpdate");
        if (bVar.bfA != null) {
            bVar.bfA.setReleaseMode(false);
        }
        bVar.bfB = cVar.ih("onUpdateReady");
        if (bVar.bfB != null) {
            bVar.bfB.setReleaseMode(false);
        }
        bVar.bfC = cVar.ih("onUpdateFailed");
        if (bVar.bfC != null) {
            bVar.bfC.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bfA != null) {
            this.bfA.call(cVar);
        }
    }

    public void Pk() {
        if (this.bfB != null) {
            this.bfB.call();
        }
    }

    public void Pl() {
        if (this.bfC != null) {
            this.bfC.call();
        }
    }
}
