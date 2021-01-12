package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b eaw;
    private b ecj;
    private com.baidu.swan.games.binding.model.c egb;
    private com.baidu.swan.games.binding.model.c egc;
    private com.baidu.swan.games.binding.model.c egd;
    private c ege;
    private com.baidu.swan.games.n.b.b egf;
    private com.baidu.swan.games.n.b.a egg;
    private com.baidu.swan.games.n.b.a egh;
    private InterfaceC0522a egi = new InterfaceC0522a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0522a
        public void ld(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.egb, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0522a
        public void aXi() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0522a
        public void wy(String str) {
            if (a.this.ecj != null) {
                a.this.ecj.wB(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0522a
        public void wz(String str) {
            if (a.this.ecj != null) {
                a.this.ecj.wC(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0522a
        public void wA(String str) {
            if (a.this.ecj != null) {
                a.this.ecj.wD(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a ega = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0522a {
        void aXi();

        void ld(int i);

        void wA(String str);

        void wy(String str);

        void wz(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.ecj = null;
        this.eaw = bVar;
        this.ega.a(this.egi);
        this.ecj = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.egf = new com.baidu.swan.games.n.b.b();
        this.egb = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.egb == null) {
            this.egb = new com.baidu.swan.games.binding.model.c();
        }
        if (this.eaw == null || this.ega == null || this.ega.aZz()) {
            this.egf.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.egb, false, this.egf);
            return;
        }
        this.ege = new c();
        try {
            if (this.ege.h(this.egb)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aZA().f(a.this.ega)) {
                            a.this.egf.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.egb, false, a.this.egf);
                            return;
                        }
                        a.this.ega.a(a.this.ege);
                    }
                }, 500L);
            } else {
                this.egf.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.egb, false, this.egf);
            }
        } catch (JSTypeMismatchException e) {
            this.egf.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.egb, false, this.egf);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.egg = new com.baidu.swan.games.n.b.a();
        this.egc = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.egc == null) {
            this.egc = new com.baidu.swan.games.binding.model.c();
        }
        if (this.eaw == null || this.ega == null || !this.ega.aZz()) {
            this.egg.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.egc, false, this.egg);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aZA().g(a.this.ega)) {
                    a.this.egg.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.egc, true, a.this.egg);
                    return;
                }
                a.this.egg.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.egc, false, a.this.egg);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aZA().g(a.this.ega);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.egh = new com.baidu.swan.games.n.b.a();
        this.egd = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.egd == null) {
            this.egd = new com.baidu.swan.games.binding.model.c();
        }
        if (this.eaw == null || this.ega == null) {
            this.egh.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.egd, false, this.egh);
            return;
        }
        final String optString = this.egd.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ega.xo(optString)) {
                    a.this.egh.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.egd, true, a.this.egh);
                    return;
                }
                a.this.egh.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.egd, false, a.this.egh);
            }
        });
    }
}
