package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction daF;
    public JsFunction daG;
    public JsFunction daH;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.daF = cVar.rB("success");
        aVar.daG = cVar.rB("fail");
        aVar.daH = cVar.rB(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.daF != null) {
            this.daF.call(obj);
        }
        if (this.daH != null) {
            this.daH.call(obj);
        }
        a(this.daG);
    }

    public void Y(Object obj) {
        if (this.daG != null) {
            this.daG.call(obj);
        }
        if (this.daH != null) {
            this.daH.call(obj);
        }
        a(this.daF);
    }

    public void onSuccess() {
        if (this.daF != null) {
            this.daF.call();
        }
        if (this.daH != null) {
            this.daH.call();
        }
        a(this.daG);
    }

    public void onFail() {
        if (this.daG != null) {
            this.daG.call();
        }
        if (this.daH != null) {
            this.daH.call();
        }
        a(this.daF);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
