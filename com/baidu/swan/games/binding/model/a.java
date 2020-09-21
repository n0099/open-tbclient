package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes3.dex */
public final class a {
    public JsFunction dsE;
    public JsFunction dsF;
    public JsFunction dsG;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dsE = cVar.vl("success");
        aVar.dsF = cVar.vl("fail");
        aVar.dsG = cVar.vl(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dsE != null) {
            this.dsE.call(obj);
        }
        if (this.dsG != null) {
            this.dsG.call(obj);
        }
        a(this.dsF);
    }

    public void Z(Object obj) {
        if (this.dsF != null) {
            this.dsF.call(obj);
        }
        if (this.dsG != null) {
            this.dsG.call(obj);
        }
        a(this.dsE);
    }

    public void onSuccess() {
        if (this.dsE != null) {
            this.dsE.call();
        }
        if (this.dsG != null) {
            this.dsG.call();
        }
        a(this.dsF);
    }

    public void onFail() {
        if (this.dsF != null) {
            this.dsF.call();
        }
        if (this.dsG != null) {
            this.dsG.call();
        }
        a(this.dsE);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
