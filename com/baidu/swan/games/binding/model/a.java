package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction clQ;
    public JsFunction clR;
    public JsFunction clS;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.clQ = cVar.oF("success");
        aVar.clR = cVar.oF(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.clS = cVar.oF(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.clQ != null) {
            this.clQ.call(obj);
        }
        if (this.clS != null) {
            this.clS.call(obj);
        }
        a(this.clR);
    }

    public void S(Object obj) {
        if (this.clR != null) {
            this.clR.call(obj);
        }
        if (this.clS != null) {
            this.clS.call(obj);
        }
        a(this.clQ);
    }

    public void onSuccess() {
        if (this.clQ != null) {
            this.clQ.call();
        }
        if (this.clS != null) {
            this.clS.call();
        }
        a(this.clR);
    }

    public void onFail() {
        if (this.clR != null) {
            this.clR.call();
        }
        if (this.clS != null) {
            this.clS.call();
        }
        a(this.clQ);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
