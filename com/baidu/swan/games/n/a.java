package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes7.dex */
public class a {
    private com.baidu.swan.games.f.b deo;
    private b dgc;
    private com.baidu.swan.games.binding.model.c djY;
    private com.baidu.swan.games.binding.model.c djZ;
    private com.baidu.swan.games.binding.model.c dka;
    private c dkb;
    private com.baidu.swan.games.n.b.b dkc;
    private com.baidu.swan.games.n.b.a dkd;
    private com.baidu.swan.games.n.b.a dke;
    private InterfaceC0450a dkf = new InterfaceC0450a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0450a
        public void iV(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.djY, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0450a
        public void aFF() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0450a
        public void tf(String str) {
            if (a.this.dgc != null) {
                a.this.dgc.ti(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0450a
        public void tg(String str) {
            if (a.this.dgc != null) {
                a.this.dgc.tj(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0450a
        public void th(String str) {
            if (a.this.dgc != null) {
                a.this.dgc.tk(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a djX = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0450a {
        void aFF();

        void iV(int i);

        void tf(String str);

        void tg(String str);

        void th(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dgc = null;
        this.deo = bVar;
        this.djX.a(this.dkf);
        this.dgc = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.dkc = new com.baidu.swan.games.n.b.b();
        this.djY = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.djY == null) {
            this.djY = new com.baidu.swan.games.binding.model.c();
        }
        if (this.deo == null || this.djX == null || this.djX.aHX()) {
            this.dkc.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.djY, false, this.dkc);
            return;
        }
        this.dkb = new c();
        try {
            if (this.dkb.h(this.djY)) {
                al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aHY().f(a.this.djX)) {
                            a.this.dkc.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.djY, false, a.this.dkc);
                            return;
                        }
                        a.this.djX.a(a.this.dkb);
                    }
                }, 500L);
            } else {
                this.dkc.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.djY, false, this.dkc);
            }
        } catch (JSTypeMismatchException e) {
            this.dkc.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.djY, false, this.dkc);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dkd = new com.baidu.swan.games.n.b.a();
        this.djZ = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.djZ == null) {
            this.djZ = new com.baidu.swan.games.binding.model.c();
        }
        if (this.deo == null || this.djX == null || !this.djX.aHX()) {
            this.dkd.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.djZ, false, this.dkd);
            return;
        }
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aHY().g(a.this.djX)) {
                    a.this.dkd.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.djZ, true, a.this.dkd);
                    return;
                }
                a.this.dkd.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.djZ, false, a.this.dkd);
            }
        });
    }

    public void hideKeyboard() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aHY().g(a.this.djX);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dke = new com.baidu.swan.games.n.b.a();
        this.dka = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dka == null) {
            this.dka = new com.baidu.swan.games.binding.model.c();
        }
        if (this.deo == null || this.djX == null) {
            this.dke.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dka, false, this.dke);
            return;
        }
        final String optString = this.dka.optString("value");
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.djX.tV(optString)) {
                    a.this.dke.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dka, true, a.this.dke);
                    return;
                }
                a.this.dke.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dka, false, a.this.dke);
            }
        });
    }
}
