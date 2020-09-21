package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public class b {
    private JsFunction dzx;
    private JsFunction dzy;
    private JsFunction dzz;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dzx = cVar.vl("onCheckForUpdate");
        if (bVar.dzx != null) {
            bVar.dzx.setReleaseMode(false);
        }
        bVar.dzy = cVar.vl("onUpdateReady");
        if (bVar.dzy != null) {
            bVar.dzy.setReleaseMode(false);
        }
        bVar.dzz = cVar.vl("onUpdateFailed");
        if (bVar.dzz != null) {
            bVar.dzz.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dzx != null) {
            this.dzx.call(cVar);
        }
    }

    public void aQp() {
        if (this.dzy != null) {
            this.dzy.call();
        }
    }

    public void aQq() {
        if (this.dzz != null) {
            this.dzz.call();
        }
    }
}
