package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes7.dex */
public final class a {
    public JsFunction dgo;
    public JsFunction dgp;
    public JsFunction dgq;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dgo = cVar.sA("success");
        aVar.dgp = cVar.sA("fail");
        aVar.dgq = cVar.sA(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dgo != null) {
            this.dgo.call(obj);
        }
        if (this.dgq != null) {
            this.dgq.call(obj);
        }
        a(this.dgp);
    }

    public void Y(Object obj) {
        if (this.dgp != null) {
            this.dgp.call(obj);
        }
        if (this.dgq != null) {
            this.dgq.call(obj);
        }
        a(this.dgo);
    }

    public void onSuccess() {
        if (this.dgo != null) {
            this.dgo.call();
        }
        if (this.dgq != null) {
            this.dgq.call();
        }
        a(this.dgp);
    }

    public void onFail() {
        if (this.dgp != null) {
            this.dgp.call();
        }
        if (this.dgq != null) {
            this.dgq.call();
        }
        a(this.dgo);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
