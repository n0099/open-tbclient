package com.baidu.swan.games.binding.model;

import com.baidu.searchbox.v8engine.JsFunction;
/* loaded from: classes8.dex */
public final class a {
    public JsFunction dqx;
    public JsFunction dqy;
    public JsFunction dqz;

    public static a f(c cVar) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dqx = cVar.uR("success");
        aVar.dqy = cVar.uR("fail");
        aVar.dqz = cVar.uR(com.baidu.mobads.openad.c.b.COMPLETE);
        return aVar;
    }

    public void onSuccess(Object obj) {
        if (this.dqx != null) {
            this.dqx.call(obj);
        }
        if (this.dqz != null) {
            this.dqz.call(obj);
        }
        a(this.dqy);
    }

    public void Y(Object obj) {
        if (this.dqy != null) {
            this.dqy.call(obj);
        }
        if (this.dqz != null) {
            this.dqz.call(obj);
        }
        a(this.dqx);
    }

    public void onSuccess() {
        if (this.dqx != null) {
            this.dqx.call();
        }
        if (this.dqz != null) {
            this.dqz.call();
        }
        a(this.dqy);
    }

    public void onFail() {
        if (this.dqy != null) {
            this.dqy.call();
        }
        if (this.dqz != null) {
            this.dqz.call();
        }
        a(this.dqx);
    }

    private void a(JsFunction jsFunction) {
        if (jsFunction != null) {
            jsFunction.release();
        }
    }
}
