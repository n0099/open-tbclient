package com.baidu.swan.games.aa;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public class b {
    private JsFunction dxw;
    private JsFunction dxx;
    private JsFunction dxy;

    public static b l(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        b bVar = new b();
        bVar.dxw = cVar.uS("onCheckForUpdate");
        if (bVar.dxw != null) {
            bVar.dxw.setReleaseMode(false);
        }
        bVar.dxx = cVar.uS("onUpdateReady");
        if (bVar.dxx != null) {
            bVar.dxx.setReleaseMode(false);
        }
        bVar.dxy = cVar.uS("onUpdateFailed");
        if (bVar.dxy != null) {
            bVar.dxy.setReleaseMode(false);
            return bVar;
        }
        return bVar;
    }

    public void b(c cVar) {
        if (this.dxw != null) {
            this.dxw.call(cVar);
        }
    }

    public void aPE() {
        if (this.dxx != null) {
            this.dxx.call();
        }
    }

    public void aPF() {
        if (this.dxy != null) {
            this.dxy.call();
        }
    }
}
