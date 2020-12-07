package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes25.dex */
public final class a {
    public JsFunction dYl;
    public JsFunction dYm;
    public JsFunction dYn;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dYl = cVar.xg("success");
        aVar.dYm = cVar.xg("fail");
        aVar.dYn = cVar.xg(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dYl != null) {
            this.dYl.call(obj);
        }
        if (this.dYn != null) {
            this.dYn.call(obj);
        }
        a(this.dYm);
    }

    public void ac(Object obj) {
        if (this.dYm != null) {
            this.dYm.call(obj);
        }
        if (this.dYn != null) {
            this.dYn.call(obj);
        }
        a(this.dYl);
    }

    public void onSuccess() {
        if (this.dYl != null) {
            this.dYl.call();
        }
        if (this.dYn != null) {
            this.dYn.call();
        }
        a(this.dYm);
    }

    public void onFail() {
        if (this.dYm != null) {
            this.dYm.call();
        }
        if (this.dYn != null) {
            this.dYn.call();
        }
        a(this.dYl);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
