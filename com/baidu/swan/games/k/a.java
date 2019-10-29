package com.baidu.swan.games.k;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.binding.model.c bBZ;
    private com.baidu.swan.games.binding.model.c bCa;
    private com.baidu.swan.games.binding.model.c bCb;
    private c bCc;
    private com.baidu.swan.games.k.b.b bCd;
    private com.baidu.swan.games.k.b.a bCe;
    private com.baidu.swan.games.k.b.a bCf;
    private b byN;
    private com.baidu.swan.games.e.b bym;
    private InterfaceC0247a bCg = new InterfaceC0247a() { // from class: com.baidu.swan.games.k.a.1
        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void fV(int i) {
            com.baidu.swan.games.k.b.b bVar = new com.baidu.swan.games.k.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bBZ, true, bVar);
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void Xs() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void kj(String str) {
            if (a.this.byN != null) {
                a.this.byN.km(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void kk(String str) {
            if (a.this.byN != null) {
                a.this.byN.kn(str);
            }
        }

        @Override // com.baidu.swan.games.k.a.InterfaceC0247a
        public void kl(String str) {
            if (a.this.byN != null) {
                a.this.byN.ko(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bBY = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0247a {
        void Xs();

        void fV(int i);

        void kj(String str);

        void kk(String str);

        void kl(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.byN = null;
        this.bym = bVar;
        this.bBY.a(this.bCg);
        this.byN = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bCd = new com.baidu.swan.games.k.b.b();
        this.bBZ = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bBZ == null || this.bym == null || this.bBY == null || this.bBY.YP()) {
            this.bCd.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bBZ, false, this.bCd);
            return;
        }
        this.bCc = new c();
        try {
            if (this.bCc.g(this.bBZ)) {
                ac.b(new Runnable() { // from class: com.baidu.swan.games.k.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.YQ().f(a.this.bBY)) {
                            a.this.bCd.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bBZ, false, a.this.bCd);
                            return;
                        }
                        a.this.bBY.a(a.this.bCc);
                    }
                }, 500L);
            } else {
                this.bCd.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bBZ, false, this.bCd);
            }
        } catch (JSTypeMismatchException e) {
            this.bCd.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bBZ, false, this.bCd);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bCe = new com.baidu.swan.games.k.b.a();
        this.bCa = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bBZ == null || this.bym == null || this.bBY == null || !this.bBY.YP()) {
            this.bCe.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bCa, false, this.bCe);
            return;
        }
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.YQ().g(a.this.bBY)) {
                    a.this.bCe.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bCa, true, a.this.bCe);
                    return;
                }
                a.this.bCe.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bCa, false, a.this.bCe);
            }
        });
    }

    public void hideKeyboard() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.YQ().g(a.this.bBY);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bCf = new com.baidu.swan.games.k.b.a();
        this.bCb = com.baidu.swan.games.binding.model.c.c(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bCb == null || this.bym == null || this.bBY == null) {
            this.bCf.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bCb, false, this.bCf);
            return;
        }
        final String optString = this.bCb.optString("value");
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bBY.kI(optString)) {
                    a.this.bCf.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bCb, true, a.this.bCf);
                    return;
                }
                a.this.bCf.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bCb, false, a.this.bCf);
            }
        });
    }
}
