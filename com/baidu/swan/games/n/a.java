package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.games.f.b efi;
    private b egW;
    private com.baidu.swan.games.binding.model.c ekO;
    private com.baidu.swan.games.binding.model.c ekP;
    private com.baidu.swan.games.binding.model.c ekQ;
    private c ekR;
    private com.baidu.swan.games.n.b.b ekS;
    private com.baidu.swan.games.n.b.a ekT;
    private com.baidu.swan.games.n.b.a ekU;
    private InterfaceC0539a ekV = new InterfaceC0539a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0539a
        public void mJ(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.ekO, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0539a
        public void bbb() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0539a
        public void xJ(String str) {
            if (a.this.egW != null) {
                a.this.egW.xM(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0539a
        public void xK(String str) {
            if (a.this.egW != null) {
                a.this.egW.xN(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0539a
        public void xL(String str) {
            if (a.this.egW != null) {
                a.this.egW.xO(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a ekN = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0539a {
        void bbb();

        void mJ(int i);

        void xJ(String str);

        void xK(String str);

        void xL(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.egW = null;
        this.efi = bVar;
        this.ekN.a(this.ekV);
        this.egW = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.ekS = new com.baidu.swan.games.n.b.b();
        this.ekO = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ekO == null) {
            this.ekO = new com.baidu.swan.games.binding.model.c();
        }
        if (this.efi == null || this.ekN == null || this.ekN.bds()) {
            this.ekS.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ekO, false, this.ekS);
            return;
        }
        this.ekR = new c();
        try {
            if (this.ekR.h(this.ekO)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.bdt().f(a.this.ekN)) {
                            a.this.ekS.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.ekO, false, a.this.ekS);
                            return;
                        }
                        a.this.ekN.a(a.this.ekR);
                    }
                }, 500L);
            } else {
                this.ekS.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.ekO, false, this.ekS);
            }
        } catch (JSTypeMismatchException e) {
            this.ekS.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ekO, false, this.ekS);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.ekT = new com.baidu.swan.games.n.b.a();
        this.ekP = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ekP == null) {
            this.ekP = new com.baidu.swan.games.binding.model.c();
        }
        if (this.efi == null || this.ekN == null || !this.ekN.bds()) {
            this.ekT.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ekP, false, this.ekT);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.bdt().g(a.this.ekN)) {
                    a.this.ekT.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.ekP, true, a.this.ekT);
                    return;
                }
                a.this.ekT.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.ekP, false, a.this.ekT);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.bdt().g(a.this.ekN);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.ekU = new com.baidu.swan.games.n.b.a();
        this.ekQ = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ekQ == null) {
            this.ekQ = new com.baidu.swan.games.binding.model.c();
        }
        if (this.efi == null || this.ekN == null) {
            this.ekU.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ekQ, false, this.ekU);
            return;
        }
        final String optString = this.ekQ.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ekN.yz(optString)) {
                    a.this.ekU.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.ekQ, true, a.this.ekU);
                    return;
                }
                a.this.ekU.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.ekQ, false, a.this.ekU);
            }
        });
    }
}
