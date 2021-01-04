package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes9.dex */
public final class a {
    public JsFunction ehi;
    public JsFunction ehj;
    public JsFunction ehk;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.ehi = cVar.xf("success");
        aVar.ehj = cVar.xf(com.baidu.pass.biometrics.face.liveness.c.a.p);
        aVar.ehk = cVar.xf(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.ehi != null) {
            this.ehi.call(obj);
        }
        if (this.ehk != null) {
            this.ehk.call(obj);
        }
        a(this.ehj);
    }

    public void ad(Object obj) {
        if (this.ehj != null) {
            this.ehj.call(obj);
        }
        if (this.ehk != null) {
            this.ehk.call(obj);
        }
        a(this.ehi);
    }

    public void onSuccess() {
        if (this.ehi != null) {
            this.ehi.call();
        }
        if (this.ehk != null) {
            this.ehk.call();
        }
        a(this.ehj);
    }

    public void onFail() {
        if (this.ehj != null) {
            this.ehj.call();
        }
        if (this.ehk != null) {
            this.ehk.call();
        }
        a(this.ehi);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
