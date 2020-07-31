package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes7.dex */
public class b {
    private JsFunction dnn;
    private JsFunction dno;
    private JsFunction dnp;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dnn = cVar.sA("onCheckForUpdate");
        if (bVar.dnn != null) {
            bVar.dnn.setReleaseMode(false);
        }
        bVar.dno = cVar.sA("onUpdateReady");
        if (bVar.dno != null) {
            bVar.dno.setReleaseMode(false);
        }
        bVar.dnp = cVar.sA("onUpdateFailed");
        if (bVar.dnp != null) {
            bVar.dnp.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dnn != null) {
            this.dnn.call(cVar);
        }
    }

    public void aGN() {
        if (this.dno != null) {
            this.dno.call();
        }
    }

    public void aGO() {
        if (this.dnp != null) {
            this.dnp.call();
        }
    }
}
