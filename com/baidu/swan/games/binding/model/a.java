package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction baQ;
    public JsFunction baR;
    public JsFunction baS;

    public static a a(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.baQ = cVar.ih("success");
        aVar.baR = cVar.ih(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.baS = cVar.ih("complete");
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.baQ != null) {
            this.baQ.call(obj);
        }
    }

    public void L(Object obj) {
        if (this.baR != null) {
            this.baR.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.baS != null) {
            this.baS.call(obj);
        }
    }

    public void onSuccess() {
        if (this.baQ != null) {
            this.baQ.call();
        }
    }

    public void onFail() {
        if (this.baR != null) {
            this.baR.call();
        }
    }

    public void onComplete() {
        if (this.baS != null) {
            this.baS.call();
        }
    }
}
