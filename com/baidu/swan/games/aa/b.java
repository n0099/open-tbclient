package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public class b {
    private JsFunction ejr;
    private JsFunction ejs;
    private JsFunction ejt;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.ejr = cVar.vU("onCheckForUpdate");
        if (bVar.ejr != null) {
            bVar.ejr.setReleaseMode(false);
        }
        bVar.ejs = cVar.vU("onUpdateReady");
        if (bVar.ejs != null) {
            bVar.ejs.setReleaseMode(false);
        }
        bVar.ejt = cVar.vU("onUpdateFailed");
        if (bVar.ejt != null) {
            bVar.ejt.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.ejr != null) {
            this.ejr.call(cVar);
        }
    }

    public void aYq() {
        if (this.ejs != null) {
            this.ejs.call();
        }
    }

    public void aYr() {
        if (this.ejt != null) {
            this.ejt.call();
        }
    }
}
