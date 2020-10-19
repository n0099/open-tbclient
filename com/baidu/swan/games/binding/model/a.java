package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public final class a {
    public JsFunction dEG;
    public JsFunction dEH;
    public JsFunction dEI;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dEG = cVar.vX("success");
        aVar.dEH = cVar.vX("fail");
        aVar.dEI = cVar.vX(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dEG != null) {
            this.dEG.call(obj);
        }
        if (this.dEI != null) {
            this.dEI.call(obj);
        }
        a(this.dEH);
    }

    public void ac(Object obj) {
        if (this.dEH != null) {
            this.dEH.call(obj);
        }
        if (this.dEI != null) {
            this.dEI.call(obj);
        }
        a(this.dEG);
    }

    public void onSuccess() {
        if (this.dEG != null) {
            this.dEG.call();
        }
        if (this.dEI != null) {
            this.dEI.call();
        }
        a(this.dEH);
    }

    public void onFail() {
        if (this.dEH != null) {
            this.dEH.call();
        }
        if (this.dEI != null) {
            this.dEI.call();
        }
        a(this.dEG);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
