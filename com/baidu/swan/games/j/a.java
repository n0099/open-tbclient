package com.baidu.swan.games.j;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class a {
    private b baO;
    private com.baidu.swan.games.e.b bad;
    private com.baidu.swan.games.binding.model.c bdK;
    private com.baidu.swan.games.binding.model.c bdL;
    private com.baidu.swan.games.binding.model.c bdM;
    private c bdN;
    private com.baidu.swan.games.j.b.b bdO;
    private com.baidu.swan.games.j.b.a bdP;
    private com.baidu.swan.games.j.b.a bdQ;
    private InterfaceC0194a bdR = new InterfaceC0194a() { // from class: com.baidu.swan.games.j.a.1
        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void eF(int i) {
            com.baidu.swan.games.j.b.b bVar = new com.baidu.swan.games.j.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bdK, true, bVar);
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void Oy() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iM(String str) {
            if (a.this.baO != null) {
                a.this.baO.iP(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iN(String str) {
            if (a.this.baO != null) {
                a.this.baO.iQ(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iO(String str) {
            if (a.this.baO != null) {
                a.this.baO.iR(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bdJ = new com.baidu.swan.games.view.b.a(this.mContext);

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
        this.baO = null;
        this.bad = bVar;
        this.bdJ.a(this.bdR);
        this.baO = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bdO = new com.baidu.swan.games.j.b.b();
        this.bdK = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdK == null || this.bad == null || this.bdJ == null || this.bdJ.PG()) {
            this.bdO.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdK, false, this.bdO);
            return;
        }
        this.bdN = new c();
        try {
            if (this.bdN.c(this.bdK)) {
                aa.a(new Runnable() { // from class: com.baidu.swan.games.j.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.PH().f(a.this.bdJ)) {
                            a.this.bdO.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bdK, false, a.this.bdO);
                            return;
                        }
                        a.this.bdJ.a(a.this.bdN);
                    }
                }, 500L);
            } else {
                this.bdO.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bdK, false, this.bdO);
            }
        } catch (JSTypeMismatchException e) {
            this.bdO.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdK, false, this.bdO);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bdP = new com.baidu.swan.games.j.b.a();
        this.bdL = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdK == null || this.bad == null || this.bdJ == null || !this.bdJ.PG()) {
            this.bdP.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdL, false, this.bdP);
            return;
        }
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.PH().g(a.this.bdJ)) {
                    a.this.bdP.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdL, true, a.this.bdP);
                    return;
                }
                a.this.bdP.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdL, false, a.this.bdP);
            }
        });
    }

    public void hideKeyboard() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.PH().g(a.this.bdJ);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bdQ = new com.baidu.swan.games.j.b.a();
        this.bdM = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdM == null || this.bad == null || this.bdJ == null) {
            this.bdQ.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdM, false, this.bdQ);
            return;
        }
        final String optString = this.bdM.optString(UBC.CONTENT_KEY_VALUE);
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bdJ.jc(optString)) {
                    a.this.bdQ.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdM, true, a.this.bdQ);
                    return;
                }
                a.this.bdQ.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdM, false, a.this.bdQ);
            }
        });
    }
}
