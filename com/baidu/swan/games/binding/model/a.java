package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction bfD;
    public JsFunction bfE;
    public JsFunction bfF;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.bfD = cVar.iY("success");
        aVar.bfE = cVar.iY(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.bfF = cVar.iY(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.bfD != null) {
            this.bfD.call(obj);
        }
    }

    public void L(Object obj) {
        if (this.bfE != null) {
            this.bfE.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.bfF != null) {
            this.bfF.call(obj);
        }
    }

    public void onSuccess() {
        if (this.bfD != null) {
            this.bfD.call();
        }
    }

    public void onFail() {
        if (this.bfE != null) {
            this.bfE.call();
        }
    }

    public void onComplete() {
        if (this.bfF != null) {
            this.bfF.call();
        }
    }
}
