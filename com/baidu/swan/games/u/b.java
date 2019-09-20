package com.baidu.swan.games.u;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public class b {
    private JsFunction bmd;
    private JsFunction bme;
    private JsFunction bmf;

    public static b i(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.bmd = cVar.ja("onCheckForUpdate");
        if (bVar.bmd != null) {
            bVar.bmd.setReleaseMode(false);
        }
        bVar.bme = cVar.ja("onUpdateReady");
        if (bVar.bme != null) {
            bVar.bme.setReleaseMode(false);
        }
        bVar.bmf = cVar.ja("onUpdateFailed");
        if (bVar.bmf != null) {
            bVar.bmf.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.bmd != null) {
            this.bmd.call(cVar);
        }
    }

    public void Ty() {
        if (this.bme != null) {
            this.bme.call();
        }
    }

    public void Tz() {
        if (this.bmf != null) {
            this.bmf.call();
        }
    }
}
