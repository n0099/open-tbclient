package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b ckm;
    private b clS;
    private com.baidu.swan.games.binding.model.c cpH;
    private com.baidu.swan.games.binding.model.c cpI;
    private com.baidu.swan.games.binding.model.c cpJ;
    private c cpK;
    private com.baidu.swan.games.m.b.b cpL;
    private com.baidu.swan.games.m.b.a cpM;
    private com.baidu.swan.games.m.b.a cpN;
    private InterfaceC0339a cpO = new InterfaceC0339a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void hT(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cpH, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void aoO() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pi(String str) {
            if (a.this.clS != null) {
                a.this.clS.pl(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pj(String str) {
            if (a.this.clS != null) {
                a.this.clS.pm(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0339a
        public void pk(String str) {
            if (a.this.clS != null) {
                a.this.clS.pn(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a cpG = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0339a {
        void aoO();

        void hT(int i);

        void pi(String str);

        void pj(String str);

        void pk(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.clS = null;
        this.ckm = bVar;
        this.cpG.a(this.cpO);
        this.clS = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.cpL = new com.baidu.swan.games.m.b.b();
        this.cpH = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpH == null) {
            this.cpH = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ckm == null || this.cpG == null || this.cpG.aqV()) {
            this.cpL.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpH, false, this.cpL);
            return;
        }
        this.cpK = new c();
        try {
            if (this.cpK.h(this.cpH)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aqW().f(a.this.cpG)) {
                            a.this.cpL.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cpH, false, a.this.cpL);
                            return;
                        }
                        a.this.cpG.a(a.this.cpK);
                    }
                }, 500L);
            } else {
                this.cpL.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cpH, false, this.cpL);
            }
        } catch (JSTypeMismatchException e) {
            this.cpL.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpH, false, this.cpL);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cpM = new com.baidu.swan.games.m.b.a();
        this.cpI = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpI == null) {
            this.cpI = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ckm == null || this.cpG == null || !this.cpG.aqV()) {
            this.cpM.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpI, false, this.cpM);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aqW().g(a.this.cpG)) {
                    a.this.cpM.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpI, true, a.this.cpM);
                    return;
                }
                a.this.cpM.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpI, false, a.this.cpM);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aqW().g(a.this.cpG);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.cpN = new com.baidu.swan.games.m.b.a();
        this.cpJ = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cpJ == null) {
            this.cpJ = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ckm == null || this.cpG == null) {
            this.cpN.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cpJ, false, this.cpN);
            return;
        }
        final String optString = this.cpJ.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cpG.pT(optString)) {
                    a.this.cpN.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cpJ, true, a.this.cpN);
                    return;
                }
                a.this.cpN.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cpJ, false, a.this.cpN);
            }
        });
    }
}
