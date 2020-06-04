package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.f.b cTU;
    private b cVH;
    private com.baidu.swan.games.binding.model.c cZA;
    private com.baidu.swan.games.binding.model.c cZB;
    private com.baidu.swan.games.binding.model.c cZC;
    private c cZD;
    private com.baidu.swan.games.n.b.b cZE;
    private com.baidu.swan.games.n.b.a cZF;
    private com.baidu.swan.games.n.b.a cZG;
    private InterfaceC0431a cZH = new InterfaceC0431a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0431a
        public void it(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cZA, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0431a
        public void aAS() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0431a
        public void rY(String str) {
            if (a.this.cVH != null) {
                a.this.cVH.sb(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0431a
        public void rZ(String str) {
            if (a.this.cVH != null) {
                a.this.cVH.sc(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0431a
        public void sa(String str) {
            if (a.this.cVH != null) {
                a.this.cVH.sd(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a cZz = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0431a {
        void aAS();

        void it(int i);

        void rY(String str);

        void rZ(String str);

        void sa(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.cVH = null;
        this.cTU = bVar;
        this.cZz.a(this.cZH);
        this.cVH = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.cZE = new com.baidu.swan.games.n.b.b();
        this.cZA = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.cZA == null) {
            this.cZA = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cTU == null || this.cZz == null || this.cZz.aCY()) {
            this.cZE.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cZA, false, this.cZE);
            return;
        }
        this.cZD = new c();
        try {
            if (this.cZD.h(this.cZA)) {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aCZ().f(a.this.cZz)) {
                            a.this.cZE.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cZA, false, a.this.cZE);
                            return;
                        }
                        a.this.cZz.a(a.this.cZD);
                    }
                }, 500L);
            } else {
                this.cZE.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cZA, false, this.cZE);
            }
        } catch (JSTypeMismatchException e) {
            this.cZE.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cZA, false, this.cZE);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cZF = new com.baidu.swan.games.n.b.a();
        this.cZB = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.cZB == null) {
            this.cZB = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cTU == null || this.cZz == null || !this.cZz.aCY()) {
            this.cZF.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cZB, false, this.cZF);
            return;
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aCZ().g(a.this.cZz)) {
                    a.this.cZF.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cZB, true, a.this.cZF);
                    return;
                }
                a.this.cZF.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cZB, false, a.this.cZF);
            }
        });
    }

    public void hideKeyboard() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aCZ().g(a.this.cZz);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.cZG = new com.baidu.swan.games.n.b.a();
        this.cZC = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.cZC == null) {
            this.cZC = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cTU == null || this.cZz == null) {
            this.cZG.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cZC, false, this.cZG);
            return;
        }
        final String optString = this.cZC.optString("value");
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cZz.sK(optString)) {
                    a.this.cZG.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cZC, true, a.this.cZG);
                    return;
                }
                a.this.cZG.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cZC, false, a.this.cZG);
            }
        });
    }
}
