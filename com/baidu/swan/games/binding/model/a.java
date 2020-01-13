package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes10.dex */
public final class a {
    public JsFunction chM;
    public JsFunction chN;
    public JsFunction chO;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.chM = cVar.oq("success");
        aVar.chN = cVar.oq(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.chO = cVar.oq(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.chM != null) {
            this.chM.call(obj);
        }
        if (this.chO != null) {
            this.chO.call(obj);
        }
        a(this.chN);
    }

    public void Q(Object obj) {
        if (this.chN != null) {
            this.chN.call(obj);
        }
        if (this.chO != null) {
            this.chO.call(obj);
        }
        a(this.chM);
    }

    public void onSuccess() {
        if (this.chM != null) {
            this.chM.call();
        }
        if (this.chO != null) {
            this.chO.call();
        }
        a(this.chN);
    }

    public void onFail() {
        if (this.chN != null) {
            this.chN.call();
        }
        if (this.chO != null) {
            this.chO.call();
        }
        a(this.chM);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
