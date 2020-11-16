package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes7.dex */
public final class a {
    public JsFunction dRn;
    public JsFunction dRo;
    public JsFunction dRp;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dRn = cVar.wz("success");
        aVar.dRo = cVar.wz("fail");
        aVar.dRp = cVar.wz(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dRn != null) {
            this.dRn.call(obj);
        }
        if (this.dRp != null) {
            this.dRp.call(obj);
        }
        a(this.dRo);
    }

    public void ac(Object obj) {
        if (this.dRo != null) {
            this.dRo.call(obj);
        }
        if (this.dRp != null) {
            this.dRp.call(obj);
        }
        a(this.dRn);
    }

    public void onSuccess() {
        if (this.dRn != null) {
            this.dRn.call();
        }
        if (this.dRp != null) {
            this.dRp.call();
        }
        a(this.dRo);
    }

    public void onFail() {
        if (this.dRo != null) {
            this.dRo.call();
        }
        if (this.dRp != null) {
            this.dRp.call();
        }
        a(this.dRn);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
