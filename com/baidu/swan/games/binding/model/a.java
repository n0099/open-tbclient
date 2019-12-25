package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes9.dex */
public final class a {
    public JsFunction chA;
    public JsFunction chB;
    public JsFunction chz;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.chz = cVar.om("success");
        aVar.chA = cVar.om(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.chB = cVar.om(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.chz != null) {
            this.chz.call(obj);
        }
        if (this.chB != null) {
            this.chB.call(obj);
        }
        a(this.chA);
    }

    public void Q(Object obj) {
        if (this.chA != null) {
            this.chA.call(obj);
        }
        if (this.chB != null) {
            this.chB.call(obj);
        }
        a(this.chz);
    }

    public void onSuccess() {
        if (this.chz != null) {
            this.chz.call();
        }
        if (this.chB != null) {
            this.chB.call();
        }
        a(this.chA);
    }

    public void onFail() {
        if (this.chA != null) {
            this.chA.call();
        }
        if (this.chB != null) {
            this.chB.call();
        }
        a(this.chz);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
