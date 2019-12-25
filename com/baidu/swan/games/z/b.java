package com.baidu.swan.games.z;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes9.dex */
public class b {
    private JsFunction cot;
    private JsFunction cou;
    private JsFunction cov;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.cot = cVar.om("onCheckForUpdate");
        if (bVar.cot != null) {
            bVar.cot.setReleaseMode(false);
        }
        bVar.cou = cVar.om("onUpdateReady");
        if (bVar.cou != null) {
            bVar.cou.setReleaseMode(false);
        }
        bVar.cov = cVar.om("onUpdateFailed");
        if (bVar.cov != null) {
            bVar.cov.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.cot != null) {
            this.cot.call(cVar);
        }
    }

    public void anl() {
        if (this.cou != null) {
            this.cou.call();
        }
    }

    public void MS() {
        if (this.cov != null) {
            this.cov.call();
        }
    }
}
