package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes11.dex */
public final class a {
    public JsFunction clS;
    public JsFunction clT;
    public JsFunction clU;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.clS = cVar.oF("success");
        aVar.clT = cVar.oF(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.clU = cVar.oF(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.clS != null) {
            this.clS.call(obj);
        }
        if (this.clU != null) {
            this.clU.call(obj);
        }
        a(this.clT);
    }

    public void S(Object obj) {
        if (this.clT != null) {
            this.clT.call(obj);
        }
        if (this.clU != null) {
            this.clU.call(obj);
        }
        a(this.clS);
    }

    public void onSuccess() {
        if (this.clS != null) {
            this.clS.call();
        }
        if (this.clU != null) {
            this.clU.call();
        }
        a(this.clT);
    }

    public void onFail() {
        if (this.clT != null) {
            this.clT.call();
        }
        if (this.clU != null) {
            this.clU.call();
        }
        a(this.clS);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
