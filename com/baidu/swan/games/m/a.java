package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cjZ;
    private b clF;
    private com.baidu.swan.games.m.b.a cpA;
    private com.baidu.swan.games.binding.model.c cpt;
    private com.baidu.swan.games.binding.model.c cpv;
    private com.baidu.swan.games.binding.model.c cpw;
    private c cpx;
    private com.baidu.swan.games.m.b.b cpy;
    private com.baidu.swan.games.m.b.a cpz;
    private InterfaceC0339a cpB = new InterfaceC0339a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void hT(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cpt, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void aoJ() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pj(String str) {
            if (a.this.clF != null) {
                a.this.clF.pm(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pk(String str) {
            if (a.this.clF != null) {
                a.this.clF.pn(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pl(String str) {
            if (a.this.clF != null) {
                a.this.clF.po(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a cps = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0339a {
        void aoJ();

        void hT(int i);

        void pj(String str);

        void pk(String str);

        void pl(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.clF = null;
        this.cjZ = bVar;
        this.cps.a(this.cpB);
        this.clF = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.cpy = new com.baidu.swan.games.m.b.b();
        this.cpt = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpt == null) {
            this.cpt = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cjZ == null || this.cps == null || this.cps.aqQ()) {
            this.cpy.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpt, false, this.cpy);
            return;
        }
        this.cpx = new c();
        try {
            if (this.cpx.h(this.cpt)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aqR().f(a.this.cps)) {
                            a.this.cpy.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cpt, false, a.this.cpy);
                            return;
                        }
                        a.this.cps.a(a.this.cpx);
                    }
                }, 500L);
            } else {
                this.cpy.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cpt, false, this.cpy);
            }
        } catch (JSTypeMismatchException e) {
            this.cpy.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpt, false, this.cpy);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cpz = new com.baidu.swan.games.m.b.a();
        this.cpv = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpv == null) {
            this.cpv = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cjZ == null || this.cps == null || !this.cps.aqQ()) {
            this.cpz.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpv, false, this.cpz);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aqR().g(a.this.cps)) {
                    a.this.cpz.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpv, true, a.this.cpz);
                    return;
                }
                a.this.cpz.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpv, false, a.this.cpz);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aqR().g(a.this.cps);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.cpA = new com.baidu.swan.games.m.b.a();
        this.cpw = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpw == null) {
            this.cpw = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cjZ == null || this.cps == null) {
            this.cpA.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpw, false, this.cpA);
            return;
        }
        final String optString = this.cpw.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cps.pU(optString)) {
                    a.this.cpA.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpw, true, a.this.cpA);
                    return;
                }
                a.this.cpA.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpw, false, a.this.cpA);
            }
        });
    }
}
