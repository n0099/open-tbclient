package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.e.b cfV;
    private b chB;
    private com.baidu.swan.games.binding.model.c clq;
    private com.baidu.swan.games.binding.model.c clr;
    private com.baidu.swan.games.binding.model.c cls;
    private c clt;
    private com.baidu.swan.games.m.b.b clu;
    private com.baidu.swan.games.m.b.a clv;
    private com.baidu.swan.games.m.b.a clw;
    private InterfaceC0329a clx = new InterfaceC0329a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0329a
        public void hC(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.clq, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0329a
        public void amw() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0329a
        public void oU(String str) {
            if (a.this.chB != null) {
                a.this.chB.oX(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0329a
        public void oV(String str) {
            if (a.this.chB != null) {
                a.this.chB.oY(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0329a
        public void oW(String str) {
            if (a.this.chB != null) {
                a.this.chB.oZ(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a clp = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0329a {
        void amw();

        void hC(int i);

        void oU(String str);

        void oV(String str);

        void oW(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.chB = null;
        this.cfV = bVar;
        this.clp.a(this.clx);
        this.chB = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.clu = new com.baidu.swan.games.m.b.b();
        this.clq = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.clq == null) {
            this.clq = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cfV == null || this.clp == null || this.clp.aoC()) {
            this.clu.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.clq, false, this.clu);
            return;
        }
        this.clt = new c();
        try {
            if (this.clt.h(this.clq)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aoD().f(a.this.clp)) {
                            a.this.clu.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.clq, false, a.this.clu);
                            return;
                        }
                        a.this.clp.a(a.this.clt);
                    }
                }, 500L);
            } else {
                this.clu.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.clq, false, this.clu);
            }
        } catch (JSTypeMismatchException e) {
            this.clu.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.clq, false, this.clu);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.clv = new com.baidu.swan.games.m.b.a();
        this.clr = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.clr == null) {
            this.clr = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cfV == null || this.clp == null || !this.clp.aoC()) {
            this.clv.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.clr, false, this.clv);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aoD().g(a.this.clp)) {
                    a.this.clv.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.clr, true, a.this.clv);
                    return;
                }
                a.this.clv.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.clr, false, a.this.clv);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aoD().g(a.this.clp);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.clw = new com.baidu.swan.games.m.b.a();
        this.cls = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cls == null) {
            this.cls = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cfV == null || this.clp == null) {
            this.clw.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cls, false, this.clw);
            return;
        }
        final String optString = this.cls.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.clp.pF(optString)) {
                    a.this.clw.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cls, true, a.this.clw);
                    return;
                }
                a.this.clw.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cls, false, a.this.clw);
            }
        });
    }
}
