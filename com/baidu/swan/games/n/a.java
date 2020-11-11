package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.f.b dQV;
    private b dSJ;
    private com.baidu.swan.games.binding.model.c dWB;
    private com.baidu.swan.games.binding.model.c dWC;
    private com.baidu.swan.games.binding.model.c dWD;
    private c dWE;
    private com.baidu.swan.games.n.b.b dWF;
    private com.baidu.swan.games.n.b.a dWG;
    private com.baidu.swan.games.n.b.a dWH;
    private InterfaceC0536a dWI = new InterfaceC0536a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0536a
        public void mh(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.dWB, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0536a
        public void aWk() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0536a
        public void xi(String str) {
            if (a.this.dSJ != null) {
                a.this.dSJ.xl(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0536a
        public void xj(String str) {
            if (a.this.dSJ != null) {
                a.this.dSJ.xm(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0536a
        public void xk(String str) {
            if (a.this.dSJ != null) {
                a.this.dSJ.xn(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a dWA = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0536a {
        void aWk();

        void mh(int i);

        void xi(String str);

        void xj(String str);

        void xk(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dSJ = null;
        this.dQV = bVar;
        this.dWA.a(this.dWI);
        this.dSJ = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.dWF = new com.baidu.swan.games.n.b.b();
        this.dWB = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dWB == null) {
            this.dWB = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dQV == null || this.dWA == null || this.dWA.aYC()) {
            this.dWF.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dWB, false, this.dWF);
            return;
        }
        this.dWE = new c();
        try {
            if (this.dWE.h(this.dWB)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aYD().f(a.this.dWA)) {
                            a.this.dWF.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.dWB, false, a.this.dWF);
                            return;
                        }
                        a.this.dWA.a(a.this.dWE);
                    }
                }, 500L);
            } else {
                this.dWF.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.dWB, false, this.dWF);
            }
        } catch (JSTypeMismatchException e) {
            this.dWF.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dWB, false, this.dWF);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dWG = new com.baidu.swan.games.n.b.a();
        this.dWC = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dWC == null) {
            this.dWC = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dQV == null || this.dWA == null || !this.dWA.aYC()) {
            this.dWG.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dWC, false, this.dWG);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aYD().g(a.this.dWA)) {
                    a.this.dWG.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dWC, true, a.this.dWG);
                    return;
                }
                a.this.dWG.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dWC, false, a.this.dWG);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aYD().g(a.this.dWA);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dWH = new com.baidu.swan.games.n.b.a();
        this.dWD = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dWD == null) {
            this.dWD = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dQV == null || this.dWA == null) {
            this.dWH.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dWD, false, this.dWH);
            return;
        }
        final String optString = this.dWD.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dWA.xY(optString)) {
                    a.this.dWH.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dWD, true, a.this.dWH);
                    return;
                }
                a.this.dWH.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dWD, false, a.this.dWH);
            }
        });
    }
}
