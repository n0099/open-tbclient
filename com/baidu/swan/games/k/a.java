package com.baidu.swan.games.k;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class a {
    private b beJ;
    private com.baidu.swan.games.e.b beh;
    private com.baidu.swan.games.binding.model.c bhY;
    private com.baidu.swan.games.binding.model.c bhZ;
    private com.baidu.swan.games.binding.model.c bia;
    private c bib;
    private com.baidu.swan.games.k.b.b bic;
    private com.baidu.swan.games.k.b.a bie;
    private com.baidu.swan.games.k.b.a bif;
    private InterfaceC0204a bih = new InterfaceC0204a() { // from class: com.baidu.swan.games.k.a.1
        @Override // com.baidu.swan.games.k.a.InterfaceC0204a
        public void eV(int i) {
            com.baidu.swan.games.k.b.b bVar = new com.baidu.swan.games.k.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bhY, true, bVar);
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0204a
        public void RE() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0204a
        public void jx(String str) {
            if (a.this.beJ != null) {
                a.this.beJ.jA(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0204a
        public void jy(String str) {
            if (a.this.beJ != null) {
                a.this.beJ.jB(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0204a
        public void jz(String str) {
            if (a.this.beJ != null) {
                a.this.beJ.jC(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bhX = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0204a {
        void RE();

        void eV(int i);

        void jx(String str);

        void jy(String str);

        void jz(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.beJ = null;
        this.beh = bVar;
        this.bhX.a(this.bih);
        this.beJ = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bic = new com.baidu.swan.games.k.b.b();
        this.bhY = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bhY == null || this.beh == null || this.bhX == null || this.bhX.Tb()) {
            this.bic.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bhY, false, this.bic);
            return;
        }
        this.bib = new c();
        try {
            if (this.bib.g(this.bhY)) {
                ac.b(new Runnable() { // from class: com.baidu.swan.games.k.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.Tc().f(a.this.bhX)) {
                            a.this.bic.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bhY, false, a.this.bic);
                            return;
                        }
                        a.this.bhX.a(a.this.bib);
                    }
                }, 500L);
            } else {
                this.bic.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bhY, false, this.bic);
            }
        } catch (JSTypeMismatchException e) {
            this.bic.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bhY, false, this.bic);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bie = new com.baidu.swan.games.k.b.a();
        this.bhZ = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bhY == null || this.beh == null || this.bhX == null || !this.bhX.Tb()) {
            this.bie.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bhZ, false, this.bie);
            return;
        }
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.Tc().g(a.this.bhX)) {
                    a.this.bie.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bhZ, true, a.this.bie);
                    return;
                }
                a.this.bie.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bhZ, false, a.this.bie);
            }
        });
    }

    public void hideKeyboard() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.Tc().g(a.this.bhX);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bif = new com.baidu.swan.games.k.b.a();
        this.bia = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bia == null || this.beh == null || this.bhX == null) {
            this.bif.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bia, false, this.bif);
            return;
        }
        final String optString = this.bia.optString(UBC.CONTENT_KEY_VALUE);
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bhX.jW(optString)) {
                    a.this.bif.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bia, true, a.this.bif);
                    return;
                }
                a.this.bif.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bia, false, a.this.bif);
            }
        });
    }
}
