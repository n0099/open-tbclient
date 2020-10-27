package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public final class a {
    public JsFunction dNd;
    public JsFunction dNe;
    public JsFunction dNf;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dNd = cVar.wq("success");
        aVar.dNe = cVar.wq("fail");
        aVar.dNf = cVar.wq(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dNd != null) {
            this.dNd.call(obj);
        }
        if (this.dNf != null) {
            this.dNf.call(obj);
        }
        a(this.dNe);
    }

    public void ac(Object obj) {
        if (this.dNe != null) {
            this.dNe.call(obj);
        }
        if (this.dNf != null) {
            this.dNf.call(obj);
        }
        a(this.dNd);
    }

    public void onSuccess() {
        if (this.dNd != null) {
            this.dNd.call();
        }
        if (this.dNf != null) {
            this.dNf.call();
        }
        a(this.dNe);
    }

    public void onFail() {
        if (this.dNe != null) {
            this.dNe.call();
        }
        if (this.dNf != null) {
            this.dNf.call();
        }
        a(this.dNd);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
