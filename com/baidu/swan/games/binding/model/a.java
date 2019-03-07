package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction baP;
    public JsFunction baQ;
    public JsFunction baR;

    public static a a(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.baP = cVar.ih("success");
        aVar.baQ = cVar.ih(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.baR = cVar.ih("complete");
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.baP != null) {
            this.baP.call(obj);
        }
    }

    public void L(Object obj) {
        if (this.baQ != null) {
            this.baQ.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.baR != null) {
            this.baR.call(obj);
        }
    }

    public void onSuccess() {
        if (this.baP != null) {
            this.baP.call();
        }
    }

    public void onFail() {
        if (this.baQ != null) {
            this.baQ.call();
        }
    }

    public void onComplete() {
        if (this.baR != null) {
            this.baR.call();
        }
    }
}
