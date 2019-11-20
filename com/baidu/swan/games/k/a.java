package com.baidu.swan.games.k;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.binding.model.c bBi;
    private com.baidu.swan.games.binding.model.c bBj;
    private com.baidu.swan.games.binding.model.c bBk;
    private c bBl;
    private com.baidu.swan.games.k.b.b bBm;
    private com.baidu.swan.games.k.b.a bBn;
    private com.baidu.swan.games.k.b.a bBo;
    private b bxW;
    private com.baidu.swan.games.e.b bxv;
    private InterfaceC0247a bBp = new InterfaceC0247a() { // from class: com.baidu.swan.games.k.a.1
        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void fU(int i) {
            com.baidu.swan.games.k.b.b bVar = new com.baidu.swan.games.k.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bBi, true, bVar);
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void Xq() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void kj(String str) {
            if (a.this.bxW != null) {
                a.this.bxW.km(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void kk(String str) {
            if (a.this.bxW != null) {
                a.this.bxW.kn(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void kl(String str) {
            if (a.this.bxW != null) {
                a.this.bxW.ko(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bBh = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0247a {
        void Xq();

        void fU(int i);

        void kj(String str);

        void kk(String str);

        void kl(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.bxW = null;
        this.bxv = bVar;
        this.bBh.a(this.bBp);
        this.bxW = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bBm = new com.baidu.swan.games.k.b.b();
        this.bBi = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bBi == null || this.bxv == null || this.bBh == null || this.bBh.YN()) {
            this.bBm.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bBi, false, this.bBm);
            return;
        }
        this.bBl = new c();
        try {
            if (this.bBl.g(this.bBi)) {
                ac.b(new Runnable() { // from class: com.baidu.swan.games.k.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.YO().f(a.this.bBh)) {
                            a.this.bBm.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bBi, false, a.this.bBm);
                            return;
                        }
                        a.this.bBh.a(a.this.bBl);
                    }
                }, 500L);
            } else {
                this.bBm.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bBi, false, this.bBm);
            }
        } catch (JSTypeMismatchException e) {
            this.bBm.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bBi, false, this.bBm);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bBn = new com.baidu.swan.games.k.b.a();
        this.bBj = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bBi == null || this.bxv == null || this.bBh == null || !this.bBh.YN()) {
            this.bBn.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bBj, false, this.bBn);
            return;
        }
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.YO().g(a.this.bBh)) {
                    a.this.bBn.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bBj, true, a.this.bBn);
                    return;
                }
                a.this.bBn.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bBj, false, a.this.bBn);
            }
        });
    }

    public void hideKeyboard() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.YO().g(a.this.bBh);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bBo = new com.baidu.swan.games.k.b.a();
        this.bBk = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bBk == null || this.bxv == null || this.bBh == null) {
            this.bBo.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bBk, false, this.bBo);
            return;
        }
        final String optString = this.bBk.optString("value");
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bBh.kI(optString)) {
                    a.this.bBo.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bBk, true, a.this.bBo);
                    return;
                }
                a.this.bBo.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bBk, false, a.this.bBo);
            }
        });
    }
}
