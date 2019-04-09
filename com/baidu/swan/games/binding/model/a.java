package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction baU;
    public JsFunction baV;
    public JsFunction baW;

    public static a a(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.baU = cVar.ii("success");
        aVar.baV = cVar.ii(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.baW = cVar.ii("complete");
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.baU != null) {
            this.baU.call(obj);
        }
    }

    public void L(Object obj) {
        if (this.baV != null) {
            this.baV.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.baW != null) {
            this.baW.call(obj);
        }
    }

    public void onSuccess() {
        if (this.baU != null) {
            this.baU.call();
        }
    }

    public void onFail() {
        if (this.baV != null) {
            this.baV.call();
        }
    }

    public void onComplete() {
        if (this.baW != null) {
            this.baW.call();
        }
    }
}
