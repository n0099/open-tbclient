package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b eee;
    private b efR;
    private com.baidu.swan.games.binding.model.c ejK;
    private com.baidu.swan.games.binding.model.c ejL;
    private com.baidu.swan.games.binding.model.c ejM;
    private c ejN;
    private com.baidu.swan.games.n.b.b ejO;
    private com.baidu.swan.games.n.b.a ejP;
    private com.baidu.swan.games.n.b.a ejQ;
    private InterfaceC0525a ejR = new InterfaceC0525a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0525a
        public void lh(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.ejK, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0525a
        public void aXx() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0525a
        public void wY(String str) {
            if (a.this.efR != null) {
                a.this.efR.xb(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0525a
        public void wZ(String str) {
            if (a.this.efR != null) {
                a.this.efR.xc(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0525a
        public void xa(String str) {
            if (a.this.efR != null) {
                a.this.efR.xd(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a ejJ = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0525a {
        void aXx();

        void lh(int i);

        void wY(String str);

        void wZ(String str);

        void xa(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.efR = null;
        this.eee = bVar;
        this.ejJ.a(this.ejR);
        this.efR = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.ejO = new com.baidu.swan.games.n.b.b();
        this.ejK = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ejK == null) {
            this.ejK = new com.baidu.swan.games.binding.model.c();
        }
        if (this.eee == null || this.ejJ == null || this.ejJ.aZP()) {
            this.ejO.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ejK, false, this.ejO);
            return;
        }
        this.ejN = new c();
        try {
            if (this.ejN.h(this.ejK)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aZQ().f(a.this.ejJ)) {
                            a.this.ejO.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.ejK, false, a.this.ejO);
                            return;
                        }
                        a.this.ejJ.a(a.this.ejN);
                    }
                }, 500L);
            } else {
                this.ejO.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.ejK, false, this.ejO);
            }
        } catch (JSTypeMismatchException e) {
            this.ejO.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ejK, false, this.ejO);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.ejP = new com.baidu.swan.games.n.b.a();
        this.ejL = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ejL == null) {
            this.ejL = new com.baidu.swan.games.binding.model.c();
        }
        if (this.eee == null || this.ejJ == null || !this.ejJ.aZP()) {
            this.ejP.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ejL, false, this.ejP);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aZQ().g(a.this.ejJ)) {
                    a.this.ejP.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.ejL, true, a.this.ejP);
                    return;
                }
                a.this.ejP.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.ejL, false, a.this.ejP);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aZQ().g(a.this.ejJ);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.ejQ = new com.baidu.swan.games.n.b.a();
        this.ejM = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ejM == null) {
            this.ejM = new com.baidu.swan.games.binding.model.c();
        }
        if (this.eee == null || this.ejJ == null) {
            this.ejQ.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ejM, false, this.ejQ);
            return;
        }
        final String optString = this.ejM.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ejJ.xO(optString)) {
                    a.this.ejQ.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.ejM, true, a.this.ejQ);
                    return;
                }
                a.this.ejQ.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.ejM, false, a.this.ejQ);
            }
        });
    }
}
