package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction cLa;
    public JsFunction cLb;
    public JsFunction cLc;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.cLa = cVar.pR("success");
        aVar.cLb = cVar.pR("fail");
        aVar.cLc = cVar.pR(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.cLa != null) {
            this.cLa.call(obj);
        }
        if (this.cLc != null) {
            this.cLc.call(obj);
        }
        a(this.cLb);
    }

    public void T(Object obj) {
        if (this.cLb != null) {
            this.cLb.call(obj);
        }
        if (this.cLc != null) {
            this.cLc.call(obj);
        }
        a(this.cLa);
    }

    public void onSuccess() {
        if (this.cLa != null) {
            this.cLa.call();
        }
        if (this.cLc != null) {
            this.cLc.call();
        }
        a(this.cLb);
    }

    public void onFail() {
        if (this.cLb != null) {
            this.cLb.call();
        }
        if (this.cLc != null) {
            this.cLc.call();
        }
        a(this.cLa);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
