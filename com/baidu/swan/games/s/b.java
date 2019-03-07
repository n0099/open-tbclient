package com.baidu.swan.games.s;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bfA;
    private JsFunction bfB;
    private JsFunction bfz;

    public static b e(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bfz = cVar.ih("onCheckForUpdate");
        if (bVar.bfz != null) {
            bVar.bfz.setReleaseMode(false);
        }
        bVar.bfA = cVar.ih("onUpdateReady");
        if (bVar.bfA != null) {
            bVar.bfA.setReleaseMode(false);
        }
        bVar.bfB = cVar.ih("onUpdateFailed");
        if (bVar.bfB != null) {
            bVar.bfB.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bfz != null) {
            this.bfz.call(cVar);
        }
    }

    public void Pk() {
        if (this.bfA != null) {
            this.bfA.call();
        }
    }

    public void Pl() {
        if (this.bfB != null) {
            this.bfB.call();
        }
    }
}
