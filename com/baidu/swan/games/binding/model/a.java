package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction byd;
    public JsFunction bye;
    public JsFunction byf;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.byd = cVar.jD("success");
        aVar.bye = cVar.jD(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.byf = cVar.jD(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.byd != null) {
            this.byd.call(obj);
        }
    }

    public void J(Object obj) {
        if (this.bye != null) {
            this.bye.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.byf != null) {
            this.byf.call(obj);
        }
    }

    public void onSuccess() {
        if (this.byd != null) {
            this.byd.call();
        }
    }

    public void onFail() {
        if (this.bye != null) {
            this.bye.call();
        }
    }

    public void onComplete() {
        if (this.byf != null) {
            this.byf.call();
        }
    }
}
