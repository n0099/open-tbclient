package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public final class a {
    public JsFunction dqB;
    public JsFunction dqC;
    public JsFunction dqD;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dqB = cVar.uS("success");
        aVar.dqC = cVar.uS("fail");
        aVar.dqD = cVar.uS(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dqB != null) {
            this.dqB.call(obj);
        }
        if (this.dqD != null) {
            this.dqD.call(obj);
        }
        a(this.dqC);
    }

    public void Y(Object obj) {
        if (this.dqC != null) {
            this.dqC.call(obj);
        }
        if (this.dqD != null) {
            this.dqD.call(obj);
        }
        a(this.dqB);
    }

    public void onSuccess() {
        if (this.dqB != null) {
            this.dqB.call();
        }
        if (this.dqD != null) {
            this.dqD.call();
        }
        a(this.dqC);
    }

    public void onFail() {
        if (this.dqC != null) {
            this.dqC.call();
        }
        if (this.dqD != null) {
            this.dqD.call();
        }
        a(this.dqB);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
