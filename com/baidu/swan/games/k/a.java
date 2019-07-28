package com.baidu.swan.games.k;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b beU;
    private b bfw;
    private com.baidu.swan.games.binding.model.c biN;
    private com.baidu.swan.games.binding.model.c biO;
    private com.baidu.swan.games.binding.model.c biP;
    private c biQ;
    private com.baidu.swan.games.k.b.b biR;
    private com.baidu.swan.games.k.b.a biS;
    private com.baidu.swan.games.k.b.a biT;
    private InterfaceC0206a biU = new InterfaceC0206a() { // from class: com.baidu.swan.games.k.a.1
        @Override // com.baidu.swan.games.k.a.InterfaceC0206a
        public void eZ(int i) {
            com.baidu.swan.games.k.b.b bVar = new com.baidu.swan.games.k.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.biN, true, bVar);
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0206a
        public void Sx() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0206a
        public void jF(String str) {
            if (a.this.bfw != null) {
                a.this.bfw.jI(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0206a
        public void jG(String str) {
            if (a.this.bfw != null) {
                a.this.bfw.jJ(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0206a
        public void jH(String str) {
            if (a.this.bfw != null) {
                a.this.bfw.jK(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a biM = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0206a {
        void Sx();

        void eZ(int i);

        void jF(String str);

        void jG(String str);

        void jH(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.bfw = null;
        this.beU = bVar;
        this.biM.a(this.biU);
        this.bfw = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.biR = new com.baidu.swan.games.k.b.b();
        this.biN = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.biN == null || this.beU == null || this.biM == null || this.biM.TU()) {
            this.biR.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.biN, false, this.biR);
            return;
        }
        this.biQ = new c();
        try {
            if (this.biQ.g(this.biN)) {
                ac.b(new Runnable() { // from class: com.baidu.swan.games.k.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.TV().f(a.this.biM)) {
                            a.this.biR.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.biN, false, a.this.biR);
                            return;
                        }
                        a.this.biM.a(a.this.biQ);
                    }
                }, 500L);
            } else {
                this.biR.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.biN, false, this.biR);
            }
        } catch (JSTypeMismatchException e) {
            this.biR.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.biN, false, this.biR);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.biS = new com.baidu.swan.games.k.b.a();
        this.biO = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.biN == null || this.beU == null || this.biM == null || !this.biM.TU()) {
            this.biS.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.biO, false, this.biS);
            return;
        }
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.TV().g(a.this.biM)) {
                    a.this.biS.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.biO, true, a.this.biS);
                    return;
                }
                a.this.biS.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.biO, false, a.this.biS);
            }
        });
    }

    public void hideKeyboard() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.TV().g(a.this.biM);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.biT = new com.baidu.swan.games.k.b.a();
        this.biP = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.biP == null || this.beU == null || this.biM == null) {
            this.biT.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.biP, false, this.biT);
            return;
        }
        final String optString = this.biP.optString(UBC.CONTENT_KEY_VALUE);
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.biM.ke(optString)) {
                    a.this.biT.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.biP, true, a.this.biT);
                    return;
                }
                a.this.biT.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.biP, false, a.this.biT);
            }
        });
    }
}
