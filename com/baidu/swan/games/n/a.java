package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes7.dex */
public class a {
    private com.baidu.swan.games.f.b dPn;
    private b dRb;
    private com.baidu.swan.games.binding.model.c dUT;
    private com.baidu.swan.games.binding.model.c dUU;
    private com.baidu.swan.games.binding.model.c dUV;
    private c dUW;
    private com.baidu.swan.games.n.b.b dUX;
    private com.baidu.swan.games.n.b.a dUY;
    private com.baidu.swan.games.n.b.a dUZ;
    private InterfaceC0534a dVa = new InterfaceC0534a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0534a
        public void md(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.dUT, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0534a
        public void aVC() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0534a
        public void xd(String str) {
            if (a.this.dRb != null) {
                a.this.dRb.xg(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0534a
        public void xe(String str) {
            if (a.this.dRb != null) {
                a.this.dRb.xh(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0534a
        public void xf(String str) {
            if (a.this.dRb != null) {
                a.this.dRb.xi(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a dUS = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0534a {
        void aVC();

        void md(int i);

        void xd(String str);

        void xe(String str);

        void xf(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dRb = null;
        this.dPn = bVar;
        this.dUS.a(this.dVa);
        this.dRb = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.dUX = new com.baidu.swan.games.n.b.b();
        this.dUT = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dUT == null) {
            this.dUT = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dPn == null || this.dUS == null || this.dUS.aXV()) {
            this.dUX.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dUT, false, this.dUX);
            return;
        }
        this.dUW = new c();
        try {
            if (this.dUW.h(this.dUT)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aXW().f(a.this.dUS)) {
                            a.this.dUX.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.dUT, false, a.this.dUX);
                            return;
                        }
                        a.this.dUS.a(a.this.dUW);
                    }
                }, 500L);
            } else {
                this.dUX.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.dUT, false, this.dUX);
            }
        } catch (JSTypeMismatchException e) {
            this.dUX.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dUT, false, this.dUX);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dUY = new com.baidu.swan.games.n.b.a();
        this.dUU = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dUU == null) {
            this.dUU = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dPn == null || this.dUS == null || !this.dUS.aXV()) {
            this.dUY.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dUU, false, this.dUY);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aXW().g(a.this.dUS)) {
                    a.this.dUY.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dUU, true, a.this.dUY);
                    return;
                }
                a.this.dUY.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dUU, false, a.this.dUY);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aXW().g(a.this.dUS);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dUZ = new com.baidu.swan.games.n.b.a();
        this.dUV = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dUV == null) {
            this.dUV = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dPn == null || this.dUS == null) {
            this.dUZ.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dUV, false, this.dUZ);
            return;
        }
        final String optString = this.dUV.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dUS.xT(optString)) {
                    a.this.dUZ.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dUV, true, a.this.dUZ);
                    return;
                }
                a.this.dUZ.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dUV, false, a.this.dUZ);
            }
        });
    }
}
