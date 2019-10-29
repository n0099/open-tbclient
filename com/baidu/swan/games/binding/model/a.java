package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction byU;
    public JsFunction byV;
    public JsFunction byW;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.byU = cVar.jD("success");
        aVar.byV = cVar.jD(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.byW = cVar.jD(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.byU != null) {
            this.byU.call(obj);
        }
    }

    public void J(Object obj) {
        if (this.byV != null) {
            this.byV.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.byW != null) {
            this.byW.call(obj);
        }
    }

    public void onSuccess() {
        if (this.byU != null) {
            this.byU.call();
        }
    }

    public void onFail() {
        if (this.byV != null) {
            this.byV.call();
        }
    }

    public void onComplete() {
        if (this.byW != null) {
            this.byW.call();
        }
    }
}
