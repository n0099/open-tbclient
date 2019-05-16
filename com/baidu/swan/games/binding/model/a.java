package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction beQ;
    public JsFunction beR;
    public JsFunction beS;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.beQ = cVar.iR("success");
        aVar.beR = cVar.iR(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.beS = cVar.iR("complete");
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.beQ != null) {
            this.beQ.call(obj);
        }
    }

    public void L(Object obj) {
        if (this.beR != null) {
            this.beR.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.beS != null) {
            this.beS.call(obj);
        }
    }

    public void onSuccess() {
        if (this.beQ != null) {
            this.beQ.call();
        }
    }

    public void onFail() {
        if (this.beR != null) {
            this.beR.call();
        }
    }

    public void onComplete() {
        if (this.beS != null) {
            this.beS.call();
        }
    }
}
