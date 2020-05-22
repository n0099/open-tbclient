package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction cVT;
    public JsFunction cVU;
    public JsFunction cVV;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.cVT = cVar.rt("success");
        aVar.cVU = cVar.rt("fail");
        aVar.cVV = cVar.rt(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.cVT != null) {
            this.cVT.call(obj);
        }
        if (this.cVV != null) {
            this.cVV.call(obj);
        }
        a(this.cVU);
    }

    public void Y(Object obj) {
        if (this.cVU != null) {
            this.cVU.call(obj);
        }
        if (this.cVV != null) {
            this.cVV.call(obj);
        }
        a(this.cVT);
    }

    public void onSuccess() {
        if (this.cVT != null) {
            this.cVT.call();
        }
        if (this.cVV != null) {
            this.cVV.call();
        }
        a(this.cVU);
    }

    public void onFail() {
        if (this.cVU != null) {
            this.cVU.call();
        }
        if (this.cVV != null) {
            this.cVV.call();
        }
        a(this.cVT);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
