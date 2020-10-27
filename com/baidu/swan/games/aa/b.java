package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public class b {
    private JsFunction dTV;
    private JsFunction dTW;
    private JsFunction dTX;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dTV = cVar.wq("onCheckForUpdate");
        if (bVar.dTV != null) {
            bVar.dTV.setReleaseMode(false);
        }
        bVar.dTW = cVar.wq("onUpdateReady");
        if (bVar.dTW != null) {
            bVar.dTW.setReleaseMode(false);
        }
        bVar.dTX = cVar.wq("onUpdateFailed");
        if (bVar.dTX != null) {
            bVar.dTX.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dTV != null) {
            this.dTV.call(cVar);
        }
    }

    public void aUS() {
        if (this.dTW != null) {
            this.dTW.call();
        }
    }

    public void aUT() {
        if (this.dTX != null) {
            this.dTX.call();
        }
    }
}
