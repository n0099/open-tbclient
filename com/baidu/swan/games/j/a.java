package com.baidu.swan.games.j;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class a {
    private b baN;
    private com.baidu.swan.games.e.b bac;
    private com.baidu.swan.games.binding.model.c bdJ;
    private com.baidu.swan.games.binding.model.c bdK;
    private com.baidu.swan.games.binding.model.c bdL;
    private c bdM;
    private com.baidu.swan.games.j.b.b bdN;
    private com.baidu.swan.games.j.b.a bdO;
    private com.baidu.swan.games.j.b.a bdP;
    private InterfaceC0194a bdQ = new InterfaceC0194a() { // from class: com.baidu.swan.games.j.a.1
        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void eF(int i) {
            com.baidu.swan.games.j.b.b bVar = new com.baidu.swan.games.j.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bdJ, true, bVar);
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void Oy() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iM(String str) {
            if (a.this.baN != null) {
                a.this.baN.iP(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iN(String str) {
            if (a.this.baN != null) {
                a.this.baN.iQ(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iO(String str) {
            if (a.this.baN != null) {
                a.this.baN.iR(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bdI = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0194a {
        void Oy();

        void eF(int i);

        void iM(String str);

        void iN(String str);

        void iO(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.baN = null;
        this.bac = bVar;
        this.bdI.a(this.bdQ);
        this.baN = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bdN = new com.baidu.swan.games.j.b.b();
        this.bdJ = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdJ == null || this.bac == null || this.bdI == null || this.bdI.PG()) {
            this.bdN.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdJ, false, this.bdN);
            return;
        }
        this.bdM = new c();
        try {
            if (this.bdM.c(this.bdJ)) {
                aa.a(new Runnable() { // from class: com.baidu.swan.games.j.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.PH().f(a.this.bdI)) {
                            a.this.bdN.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bdJ, false, a.this.bdN);
                            return;
                        }
                        a.this.bdI.a(a.this.bdM);
                    }
                }, 500L);
            } else {
                this.bdN.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bdJ, false, this.bdN);
            }
        } catch (JSTypeMismatchException e) {
            this.bdN.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdJ, false, this.bdN);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bdO = new com.baidu.swan.games.j.b.a();
        this.bdK = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdJ == null || this.bac == null || this.bdI == null || !this.bdI.PG()) {
            this.bdO.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdK, false, this.bdO);
            return;
        }
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.PH().g(a.this.bdI)) {
                    a.this.bdO.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdK, true, a.this.bdO);
                    return;
                }
                a.this.bdO.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdK, false, a.this.bdO);
            }
        });
    }

    public void hideKeyboard() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.PH().g(a.this.bdI);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bdP = new com.baidu.swan.games.j.b.a();
        this.bdL = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdL == null || this.bac == null || this.bdI == null) {
            this.bdP.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdL, false, this.bdP);
            return;
        }
        final String optString = this.bdL.optString(UBC.CONTENT_KEY_VALUE);
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bdI.jc(optString)) {
                    a.this.bdP.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdL, true, a.this.bdP);
                    return;
                }
                a.this.bdP.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdL, false, a.this.bdP);
            }
        });
    }
}
