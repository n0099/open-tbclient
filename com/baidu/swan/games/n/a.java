package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.swan.games.f.b dqC;
    private b dsr;
    private com.baidu.swan.games.binding.model.c dwl;
    private com.baidu.swan.games.binding.model.c dwm;
    private com.baidu.swan.games.binding.model.c dwn;
    private c dwo;
    private com.baidu.swan.games.n.b.b dwp;
    private com.baidu.swan.games.n.b.a dwq;
    private com.baidu.swan.games.n.b.a dwr;
    private InterfaceC0493a dws = new InterfaceC0493a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0493a
        public void lp(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.dwl, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0493a
        public void aPh() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0493a
        public void vP(String str) {
            if (a.this.dsr != null) {
                a.this.dsr.vS(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0493a
        public void vQ(String str) {
            if (a.this.dsr != null) {
                a.this.dsr.vT(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0493a
        public void vR(String str) {
            if (a.this.dsr != null) {
                a.this.dsr.vU(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a dwk = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0493a {
        void aPh();

        void lp(int i);

        void vP(String str);

        void vQ(String str);

        void vR(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dsr = null;
        this.dqC = bVar;
        this.dwk.a(this.dws);
        this.dsr = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.dwp = new com.baidu.swan.games.n.b.b();
        this.dwl = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dwl == null) {
            this.dwl = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dqC == null || this.dwk == null || this.dwk.aRz()) {
            this.dwp.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dwl, false, this.dwp);
            return;
        }
        this.dwo = new c();
        try {
            if (this.dwo.h(this.dwl)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aRA().f(a.this.dwk)) {
                            a.this.dwp.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.dwl, false, a.this.dwp);
                            return;
                        }
                        a.this.dwk.a(a.this.dwo);
                    }
                }, 500L);
            } else {
                this.dwp.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.dwl, false, this.dwp);
            }
        } catch (JSTypeMismatchException e) {
            this.dwp.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dwl, false, this.dwp);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dwq = new com.baidu.swan.games.n.b.a();
        this.dwm = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dwm == null) {
            this.dwm = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dqC == null || this.dwk == null || !this.dwk.aRz()) {
            this.dwq.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dwm, false, this.dwq);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aRA().g(a.this.dwk)) {
                    a.this.dwq.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dwm, true, a.this.dwq);
                    return;
                }
                a.this.dwq.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dwm, false, a.this.dwq);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aRA().g(a.this.dwk);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dwr = new com.baidu.swan.games.n.b.a();
        this.dwn = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dwn == null) {
            this.dwn = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dqC == null || this.dwk == null) {
            this.dwr.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dwn, false, this.dwr);
            return;
        }
        final String optString = this.dwn.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dwk.wF(optString)) {
                    a.this.dwr.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dwn, true, a.this.dwr);
                    return;
                }
                a.this.dwr.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dwn, false, a.this.dwr);
            }
        });
    }
}
