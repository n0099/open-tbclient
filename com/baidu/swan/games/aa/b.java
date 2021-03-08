package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public class b {
    private JsFunction emZ;
    private JsFunction ena;
    private JsFunction enb;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.emZ = cVar.wu("onCheckForUpdate");
        if (bVar.emZ != null) {
            bVar.emZ.setReleaseMode(false);
        }
        bVar.ena = cVar.wu("onUpdateReady");
        if (bVar.ena != null) {
            bVar.ena.setReleaseMode(false);
        }
        bVar.enb = cVar.wu("onUpdateFailed");
        if (bVar.enb != null) {
            bVar.enb.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.emZ != null) {
            this.emZ.call(cVar);
        }
    }

    public void aYF() {
        if (this.ena != null) {
            this.ena.call();
        }
    }

    public void aYG() {
        if (this.enb != null) {
            this.enb.call();
        }
    }
}
