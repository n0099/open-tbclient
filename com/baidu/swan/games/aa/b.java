package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes9.dex */
public class b {
    private JsFunction eog;
    private JsFunction eoh;
    private JsFunction eoi;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.eog = cVar.xf("onCheckForUpdate");
        if (bVar.eog != null) {
            bVar.eog.setReleaseMode(false);
        }
        bVar.eoh = cVar.xf("onUpdateReady");
        if (bVar.eoh != null) {
            bVar.eoh.setReleaseMode(false);
        }
        bVar.eoi = cVar.xf("onUpdateFailed");
        if (bVar.eoi != null) {
            bVar.eoi.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.eog != null) {
            this.eog.call(cVar);
        }
    }

    public void bcj() {
        if (this.eoh != null) {
            this.eoh.call();
        }
    }

    public void bck() {
        if (this.eoi != null) {
            this.eoi.call();
        }
    }
}
