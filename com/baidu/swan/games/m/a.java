package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b ckb;
    private b clH;
    private com.baidu.swan.games.m.b.b cpA;
    private com.baidu.swan.games.m.b.a cpB;
    private com.baidu.swan.games.m.b.a cpC;
    private com.baidu.swan.games.binding.model.c cpw;
    private com.baidu.swan.games.binding.model.c cpx;
    private com.baidu.swan.games.binding.model.c cpy;
    private c cpz;
    private InterfaceC0339a cpD = new InterfaceC0339a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void hT(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cpw, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void aoL() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pj(String str) {
            if (a.this.clH != null) {
                a.this.clH.pm(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pk(String str) {
            if (a.this.clH != null) {
                a.this.clH.pn(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pl(String str) {
            if (a.this.clH != null) {
                a.this.clH.po(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a cpv = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0339a {
        void aoL();

        void hT(int i);

        void pj(String str);

        void pk(String str);

        void pl(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.clH = null;
        this.ckb = bVar;
        this.cpv.a(this.cpD);
        this.clH = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.cpA = new com.baidu.swan.games.m.b.b();
        this.cpw = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpw == null) {
            this.cpw = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ckb == null || this.cpv == null || this.cpv.aqS()) {
            this.cpA.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpw, false, this.cpA);
            return;
        }
        this.cpz = new c();
        try {
            if (this.cpz.h(this.cpw)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aqT().f(a.this.cpv)) {
                            a.this.cpA.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cpw, false, a.this.cpA);
                            return;
                        }
                        a.this.cpv.a(a.this.cpz);
                    }
                }, 500L);
            } else {
                this.cpA.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cpw, false, this.cpA);
            }
        } catch (JSTypeMismatchException e) {
            this.cpA.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpw, false, this.cpA);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cpB = new com.baidu.swan.games.m.b.a();
        this.cpx = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpx == null) {
            this.cpx = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ckb == null || this.cpv == null || !this.cpv.aqS()) {
            this.cpB.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpx, false, this.cpB);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aqT().g(a.this.cpv)) {
                    a.this.cpB.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpx, true, a.this.cpB);
                    return;
                }
                a.this.cpB.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpx, false, a.this.cpB);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aqT().g(a.this.cpv);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.cpC = new com.baidu.swan.games.m.b.a();
        this.cpy = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpy == null) {
            this.cpy = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ckb == null || this.cpv == null) {
            this.cpC.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpy, false, this.cpC);
            return;
        }
        final String optString = this.cpy.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cpv.pU(optString)) {
                    a.this.cpC.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpy, true, a.this.cpC);
                    return;
                }
                a.this.cpC.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpy, false, a.this.cpC);
            }
        });
    }
}
