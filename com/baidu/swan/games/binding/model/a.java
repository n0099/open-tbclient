package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction cLg;
    public JsFunction cLh;
    public JsFunction cLi;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.cLg = cVar.pR("success");
        aVar.cLh = cVar.pR("fail");
        aVar.cLi = cVar.pR(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.cLg != null) {
            this.cLg.call(obj);
        }
        if (this.cLi != null) {
            this.cLi.call(obj);
        }
        a(this.cLh);
    }

    public void U(Object obj) {
        if (this.cLh != null) {
            this.cLh.call(obj);
        }
        if (this.cLi != null) {
            this.cLi.call(obj);
        }
        a(this.cLg);
    }

    public void onSuccess() {
        if (this.cLg != null) {
            this.cLg.call();
        }
        if (this.cLi != null) {
            this.cLi.call();
        }
        a(this.cLh);
    }

    public void onFail() {
        if (this.cLh != null) {
            this.cLh.call();
        }
        if (this.cLi != null) {
            this.cLi.call();
        }
        a(this.cLg);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
