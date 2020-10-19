package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.games.f.b dCG;
    private b dEu;
    private com.baidu.swan.games.binding.model.c dIm;
    private com.baidu.swan.games.binding.model.c dIn;
    private com.baidu.swan.games.binding.model.c dIo;
    private c dIp;
    private com.baidu.swan.games.n.b.b dIq;
    private com.baidu.swan.games.n.b.a dIr;
    private com.baidu.swan.games.n.b.a dIs;
    private InterfaceC0510a dIt = new InterfaceC0510a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0510a
        public void lM(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.dIm, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0510a
        public void aRQ() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0510a
        public void wB(String str) {
            if (a.this.dEu != null) {
                a.this.dEu.wE(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0510a
        public void wC(String str) {
            if (a.this.dEu != null) {
                a.this.dEu.wF(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0510a
        public void wD(String str) {
            if (a.this.dEu != null) {
                a.this.dEu.wG(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a dIl = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0510a {
        void aRQ();

        void lM(int i);

        void wB(String str);

        void wC(String str);

        void wD(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dEu = null;
        this.dCG = bVar;
        this.dIl.a(this.dIt);
        this.dEu = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.dIq = new com.baidu.swan.games.n.b.b();
        this.dIm = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dIm == null) {
            this.dIm = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dCG == null || this.dIl == null || this.dIl.aUi()) {
            this.dIq.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dIm, false, this.dIq);
            return;
        }
        this.dIp = new c();
        try {
            if (this.dIp.h(this.dIm)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aUj().f(a.this.dIl)) {
                            a.this.dIq.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.dIm, false, a.this.dIq);
                            return;
                        }
                        a.this.dIl.a(a.this.dIp);
                    }
                }, 500L);
            } else {
                this.dIq.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.dIm, false, this.dIq);
            }
        } catch (JSTypeMismatchException e) {
            this.dIq.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dIm, false, this.dIq);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dIr = new com.baidu.swan.games.n.b.a();
        this.dIn = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dIn == null) {
            this.dIn = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dCG == null || this.dIl == null || !this.dIl.aUi()) {
            this.dIr.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dIn, false, this.dIr);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aUj().g(a.this.dIl)) {
                    a.this.dIr.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dIn, true, a.this.dIr);
                    return;
                }
                a.this.dIr.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dIn, false, a.this.dIr);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aUj().g(a.this.dIl);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dIs = new com.baidu.swan.games.n.b.a();
        this.dIo = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dIo == null) {
            this.dIo = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dCG == null || this.dIl == null) {
            this.dIs.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dIo, false, this.dIs);
            return;
        }
        final String optString = this.dIo.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dIl.xr(optString)) {
                    a.this.dIs.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dIo, true, a.this.dIs);
                    return;
                }
                a.this.dIs.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dIo, false, a.this.dIs);
            }
        });
    }
}
