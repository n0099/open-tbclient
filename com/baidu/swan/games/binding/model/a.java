package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public final class a {
    public JsFunction dSV;
    public JsFunction dSW;
    public JsFunction dSX;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dSV = cVar.wE("success");
        aVar.dSW = cVar.wE("fail");
        aVar.dSX = cVar.wE(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dSV != null) {
            this.dSV.call(obj);
        }
        if (this.dSX != null) {
            this.dSX.call(obj);
        }
        a(this.dSW);
    }

    public void ac(Object obj) {
        if (this.dSW != null) {
            this.dSW.call(obj);
        }
        if (this.dSX != null) {
            this.dSX.call(obj);
        }
        a(this.dSV);
    }

    public void onSuccess() {
        if (this.dSV != null) {
            this.dSV.call();
        }
        if (this.dSX != null) {
            this.dSX.call();
        }
        a(this.dSW);
    }

    public void onFail() {
        if (this.dSW != null) {
            this.dSW.call();
        }
        if (this.dSX != null) {
            this.dSX.call();
        }
        a(this.dSV);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
