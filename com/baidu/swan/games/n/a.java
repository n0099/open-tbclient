package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.games.f.b ecD;
    private b eeq;
    private com.baidu.swan.games.binding.model.c eij;
    private com.baidu.swan.games.binding.model.c eik;
    private com.baidu.swan.games.binding.model.c eil;
    private c eim;
    private com.baidu.swan.games.n.b.b ein;
    private com.baidu.swan.games.n.b.a eio;
    private com.baidu.swan.games.n.b.a eip;
    private InterfaceC0519a eiq = new InterfaceC0519a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0519a
        public void lg(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.eij, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0519a
        public void aXu() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0519a
        public void wR(String str) {
            if (a.this.eeq != null) {
                a.this.eeq.wU(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0519a
        public void wS(String str) {
            if (a.this.eeq != null) {
                a.this.eeq.wV(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0519a
        public void wT(String str) {
            if (a.this.eeq != null) {
                a.this.eeq.wW(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a eii = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0519a {
        void aXu();

        void lg(int i);

        void wR(String str);

        void wS(String str);

        void wT(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.eeq = null;
        this.ecD = bVar;
        this.eii.a(this.eiq);
        this.eeq = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.ein = new com.baidu.swan.games.n.b.b();
        this.eij = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.eij == null) {
            this.eij = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ecD == null || this.eii == null || this.eii.aZM()) {
            this.ein.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.eij, false, this.ein);
            return;
        }
        this.eim = new c();
        try {
            if (this.eim.h(this.eij)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aZN().f(a.this.eii)) {
                            a.this.ein.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.eij, false, a.this.ein);
                            return;
                        }
                        a.this.eii.a(a.this.eim);
                    }
                }, 500L);
            } else {
                this.ein.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.eij, false, this.ein);
            }
        } catch (JSTypeMismatchException e) {
            this.ein.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.eij, false, this.ein);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.eio = new com.baidu.swan.games.n.b.a();
        this.eik = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.eik == null) {
            this.eik = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ecD == null || this.eii == null || !this.eii.aZM()) {
            this.eio.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.eik, false, this.eio);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aZN().g(a.this.eii)) {
                    a.this.eio.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.eik, true, a.this.eio);
                    return;
                }
                a.this.eio.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.eik, false, a.this.eio);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aZN().g(a.this.eii);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.eip = new com.baidu.swan.games.n.b.a();
        this.eil = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.eil == null) {
            this.eil = new com.baidu.swan.games.binding.model.c();
        }
        if (this.ecD == null || this.eii == null) {
            this.eip.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.eil, false, this.eip);
            return;
        }
        final String optString = this.eil.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.eii.xH(optString)) {
                    a.this.eip.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.eil, true, a.this.eip);
                    return;
                }
                a.this.eip.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.eil, false, a.this.eip);
            }
        });
    }
}
