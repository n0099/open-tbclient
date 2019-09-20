package com.baidu.swan.games.binding.model;

import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes2.dex */
public final class a {
    public JsFunction bgb;
    public JsFunction bgc;
    public JsFunction bgd;

    public static a e(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.bgb = cVar.ja("success");
        aVar.bgc = cVar.ja(LivenessStat.TYPE_FACE_MATCH_FAIL);
        aVar.bgd = cVar.ja(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.bgb != null) {
            this.bgb.call(obj);
        }
    }

    public void L(Object obj) {
        if (this.bgc != null) {
            this.bgc.call(obj);
        }
    }

    public void onComplete(Object obj) {
        if (this.bgd != null) {
            this.bgd.call(obj);
        }
    }

    public void onSuccess() {
        if (this.bgb != null) {
            this.bgb.call();
        }
    }

    public void onFail() {
        if (this.bgc != null) {
            this.bgc.call();
        }
    }

    public void onComplete() {
        if (this.bgd != null) {
            this.bgd.call();
        }
    }
}
