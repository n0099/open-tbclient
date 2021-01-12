package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public final class a {
    public JsFunction ecv;
    public JsFunction ecw;
    public JsFunction ecx;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.ecv = cVar.vU("success");
        aVar.ecw = cVar.vU(com.baidu.pass.biometrics.face.liveness.c.a.p);
        aVar.ecx = cVar.vU(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.ecv != null) {
            this.ecv.call(obj);
        }
        if (this.ecx != null) {
            this.ecx.call(obj);
        }
        a(this.ecw);
    }

    public void ad(Object obj) {
        if (this.ecw != null) {
            this.ecw.call(obj);
        }
        if (this.ecx != null) {
            this.ecx.call(obj);
        }
        a(this.ecv);
    }

    public void onSuccess() {
        if (this.ecv != null) {
            this.ecv.call();
        }
        if (this.ecx != null) {
            this.ecx.call();
        }
        a(this.ecw);
    }

    public void onFail() {
        if (this.ecw != null) {
            this.ecw.call();
        }
        if (this.ecx != null) {
            this.ecx.call();
        }
        a(this.ecv);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
