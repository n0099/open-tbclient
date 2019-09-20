package com.baidu.swan.games.k;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class a {
    private b bfU;
    private com.baidu.swan.games.e.b bft;
    private com.baidu.swan.games.binding.model.c bjl;
    private com.baidu.swan.games.binding.model.c bjm;
    private com.baidu.swan.games.binding.model.c bjn;
    private c bjo;
    private com.baidu.swan.games.k.b.b bjp;
    private com.baidu.swan.games.k.b.a bjq;
    private com.baidu.swan.games.k.b.a bjr;
    private InterfaceC0215a bjs = new InterfaceC0215a() { // from class: com.baidu.swan.games.k.a.1
        @Override // com.baidu.swan.games.k.a.InterfaceC0215a
        public void fa(int i) {
            com.baidu.swan.games.k.b.b bVar = new com.baidu.swan.games.k.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bjl, true, bVar);
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0215a
        public void SB() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0215a
        public void jH(String str) {
            if (a.this.bfU != null) {
                a.this.bfU.jK(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0215a
        public void jI(String str) {
            if (a.this.bfU != null) {
                a.this.bfU.jL(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0215a
        public void jJ(String str) {
            if (a.this.bfU != null) {
                a.this.bfU.jM(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bjk = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0215a {
        void SB();

        void fa(int i);

        void jH(String str);

        void jI(String str);

        void jJ(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.bfU = null;
        this.bft = bVar;
        this.bjk.a(this.bjs);
        this.bfU = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bjp = new com.baidu.swan.games.k.b.b();
        this.bjl = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bjl == null || this.bft == null || this.bjk == null || this.bjk.TY()) {
            this.bjp.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bjl, false, this.bjp);
            return;
        }
        this.bjo = new c();
        try {
            if (this.bjo.g(this.bjl)) {
                ac.b(new Runnable() { // from class: com.baidu.swan.games.k.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.TZ().f(a.this.bjk)) {
                            a.this.bjp.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bjl, false, a.this.bjp);
                            return;
                        }
                        a.this.bjk.a(a.this.bjo);
                    }
                }, 500L);
            } else {
                this.bjp.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bjl, false, this.bjp);
            }
        } catch (JSTypeMismatchException e) {
            this.bjp.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bjl, false, this.bjp);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bjq = new com.baidu.swan.games.k.b.a();
        this.bjm = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bjl == null || this.bft == null || this.bjk == null || !this.bjk.TY()) {
            this.bjq.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bjm, false, this.bjq);
            return;
        }
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.TZ().g(a.this.bjk)) {
                    a.this.bjq.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bjm, true, a.this.bjq);
                    return;
                }
                a.this.bjq.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bjm, false, a.this.bjq);
            }
        });
    }

    public void hideKeyboard() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.TZ().g(a.this.bjk);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bjr = new com.baidu.swan.games.k.b.a();
        this.bjn = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bjn == null || this.bft == null || this.bjk == null) {
            this.bjr.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bjn, false, this.bjr);
            return;
        }
        final String optString = this.bjn.optString(UBC.CONTENT_KEY_VALUE);
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bjk.kg(optString)) {
                    a.this.bjr.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bjn, true, a.this.bjr);
                    return;
                }
                a.this.bjr.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bjn, false, a.this.bjr);
            }
        });
    }
}
