package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction cme;
    public JsFunction cmf;
    public JsFunction cmg;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.cme = cVar.oE("success");
        aVar.cmf = cVar.oE(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.cmg = cVar.oE(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.cme != null) {
            this.cme.call(obj);
        }
        if (this.cmg != null) {
            this.cmg.call(obj);
        }
        a(this.cmf);
    }

    public void S(Object obj) {
        if (this.cmf != null) {
            this.cmf.call(obj);
        }
        if (this.cmg != null) {
            this.cmg.call(obj);
        }
        a(this.cme);
    }

    public void onSuccess() {
        if (this.cme != null) {
            this.cme.call();
        }
        if (this.cmg != null) {
            this.cmg.call();
        }
        a(this.cmf);
    }

    public void onFail() {
        if (this.cmf != null) {
            this.cmf.call();
        }
        if (this.cmg != null) {
            this.cmg.call();
        }
        a(this.cme);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
