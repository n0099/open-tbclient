package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction clR;
    public JsFunction clS;
    public JsFunction clT;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.clR = cVar.oF("success");
        aVar.clS = cVar.oF(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.clT = cVar.oF(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.clR != null) {
            this.clR.call(obj);
        }
        if (this.clT != null) {
            this.clT.call(obj);
        }
        a(this.clS);
    }

    public void S(Object obj) {
        if (this.clS != null) {
            this.clS.call(obj);
        }
        if (this.clT != null) {
            this.clT.call(obj);
        }
        a(this.clR);
    }

    public void onSuccess() {
        if (this.clR != null) {
            this.clR.call();
        }
        if (this.clT != null) {
            this.clT.call();
        }
        a(this.clS);
    }

    public void onFail() {
        if (this.clS != null) {
            this.clS.call();
        }
        if (this.clT != null) {
            this.clT.call();
        }
        a(this.clR);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
