package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes9.dex */
public final class a {
    public JsFunction eeC;
    public JsFunction eeD;
    public JsFunction eeE;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.eeC = cVar.wn("success");
        aVar.eeD = cVar.wn(com.baidu.pass.biometrics.face.liveness.c.a.p);
        aVar.eeE = cVar.wn("complete");
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.eeC != null) {
            this.eeC.call(obj);
        }
        if (this.eeE != null) {
            this.eeE.call(obj);
        }
        a(this.eeD);
    }

    public void ad(Object obj) {
        if (this.eeD != null) {
            this.eeD.call(obj);
        }
        if (this.eeE != null) {
            this.eeE.call(obj);
        }
        a(this.eeC);
    }

    public void onSuccess() {
        if (this.eeC != null) {
            this.eeC.call();
        }
        if (this.eeE != null) {
            this.eeE.call();
        }
        a(this.eeD);
    }

    public void onFail() {
        if (this.eeD != null) {
            this.eeD.call();
        }
        if (this.eeE != null) {
            this.eeE.call();
        }
        a(this.eeC);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
