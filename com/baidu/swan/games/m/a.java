package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cka;
    private b clG;
    private com.baidu.swan.games.m.b.a cpA;
    private com.baidu.swan.games.m.b.a cpB;
    private com.baidu.swan.games.binding.model.c cpv;
    private com.baidu.swan.games.binding.model.c cpw;
    private com.baidu.swan.games.binding.model.c cpx;
    private c cpy;
    private com.baidu.swan.games.m.b.b cpz;
    private InterfaceC0339a cpC = new InterfaceC0339a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void hT(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cpv, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void aoL() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pj(String str) {
            if (a.this.clG != null) {
                a.this.clG.pm(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pk(String str) {
            if (a.this.clG != null) {
                a.this.clG.pn(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pl(String str) {
            if (a.this.clG != null) {
                a.this.clG.po(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a cpt = new com.baidu.swan.games.view.b.a(this.mContext);

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
        this.clG = null;
        this.cka = bVar;
        this.cpt.a(this.cpC);
        this.clG = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.cpz = new com.baidu.swan.games.m.b.b();
        this.cpv = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpv == null) {
            this.cpv = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cka == null || this.cpt == null || this.cpt.aqS()) {
            this.cpz.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpv, false, this.cpz);
            return;
        }
        this.cpy = new c();
        try {
            if (this.cpy.h(this.cpv)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aqT().f(a.this.cpt)) {
                            a.this.cpz.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cpv, false, a.this.cpz);
                            return;
                        }
                        a.this.cpt.a(a.this.cpy);
                    }
                }, 500L);
            } else {
                this.cpz.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cpv, false, this.cpz);
            }
        } catch (JSTypeMismatchException e) {
            this.cpz.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpv, false, this.cpz);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cpA = new com.baidu.swan.games.m.b.a();
        this.cpw = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpw == null) {
            this.cpw = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cka == null || this.cpt == null || !this.cpt.aqS()) {
            this.cpA.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpw, false, this.cpA);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aqT().g(a.this.cpt)) {
                    a.this.cpA.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpw, true, a.this.cpA);
                    return;
                }
                a.this.cpA.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpw, false, a.this.cpA);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aqT().g(a.this.cpt);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.cpB = new com.baidu.swan.games.m.b.a();
        this.cpx = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpx == null) {
            this.cpx = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cka == null || this.cpt == null) {
            this.cpB.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpx, false, this.cpB);
            return;
        }
        final String optString = this.cpx.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cpt.pU(optString)) {
                    a.this.cpB.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpx, true, a.this.cpB);
                    return;
                }
                a.this.cpB.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpx, false, a.this.cpB);
            }
        });
    }
}
