package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public final class a {
    public JsFunction egd;
    public JsFunction ege;
    public JsFunction egf;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.egd = cVar.wu("success");
        aVar.ege = cVar.wu(com.baidu.pass.biometrics.face.liveness.c.a.p);
        aVar.egf = cVar.wu("complete");
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.egd != null) {
            this.egd.call(obj);
        }
        if (this.egf != null) {
            this.egf.call(obj);
        }
        a(this.ege);
    }

    public void af(Object obj) {
        if (this.ege != null) {
            this.ege.call(obj);
        }
        if (this.egf != null) {
            this.egf.call(obj);
        }
        a(this.egd);
    }

    public void onSuccess() {
        if (this.egd != null) {
            this.egd.call();
        }
        if (this.egf != null) {
            this.egf.call();
        }
        a(this.ege);
    }

    public void onFail() {
        if (this.ege != null) {
            this.ege.call();
        }
        if (this.egf != null) {
            this.egf.call();
        }
        a(this.egd);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
