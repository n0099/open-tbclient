package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.f.b dLd;
    private b dMR;
    private com.baidu.swan.games.binding.model.c dQJ;
    private com.baidu.swan.games.binding.model.c dQK;
    private com.baidu.swan.games.binding.model.c dQL;
    private c dQM;
    private com.baidu.swan.games.n.b.b dQN;
    private com.baidu.swan.games.n.b.a dQO;
    private com.baidu.swan.games.n.b.a dQP;
    private InterfaceC0524a dQQ = new InterfaceC0524a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0524a
        public void lX(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.dQJ, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0524a
        public void aTK() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0524a
        public void wU(String str) {
            if (a.this.dMR != null) {
                a.this.dMR.wX(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0524a
        public void wV(String str) {
            if (a.this.dMR != null) {
                a.this.dMR.wY(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0524a
        public void wW(String str) {
            if (a.this.dMR != null) {
                a.this.dMR.wZ(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a dQI = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0524a {
        void aTK();

        void lX(int i);

        void wU(String str);

        void wV(String str);

        void wW(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dMR = null;
        this.dLd = bVar;
        this.dQI.a(this.dQQ);
        this.dMR = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.dQN = new com.baidu.swan.games.n.b.b();
        this.dQJ = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dQJ == null) {
            this.dQJ = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dLd == null || this.dQI == null || this.dQI.aWc()) {
            this.dQN.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dQJ, false, this.dQN);
            return;
        }
        this.dQM = new c();
        try {
            if (this.dQM.h(this.dQJ)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aWd().f(a.this.dQI)) {
                            a.this.dQN.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.dQJ, false, a.this.dQN);
                            return;
                        }
                        a.this.dQI.a(a.this.dQM);
                    }
                }, 500L);
            } else {
                this.dQN.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.dQJ, false, this.dQN);
            }
        } catch (JSTypeMismatchException e) {
            this.dQN.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dQJ, false, this.dQN);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dQO = new com.baidu.swan.games.n.b.a();
        this.dQK = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dQK == null) {
            this.dQK = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dLd == null || this.dQI == null || !this.dQI.aWc()) {
            this.dQO.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dQK, false, this.dQO);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aWd().g(a.this.dQI)) {
                    a.this.dQO.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dQK, true, a.this.dQO);
                    return;
                }
                a.this.dQO.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dQK, false, a.this.dQO);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aWd().g(a.this.dQI);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dQP = new com.baidu.swan.games.n.b.a();
        this.dQL = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dQL == null) {
            this.dQL = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dLd == null || this.dQI == null) {
            this.dQP.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dQL, false, this.dQP);
            return;
        }
        final String optString = this.dQL.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dQI.xK(optString)) {
                    a.this.dQP.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dQL, true, a.this.dQP);
                    return;
                }
                a.this.dQP.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dQL, false, a.this.dQP);
            }
        });
    }
}
