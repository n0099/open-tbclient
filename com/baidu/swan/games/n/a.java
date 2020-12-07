package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes25.dex */
public class a {
    private com.baidu.swan.games.f.b dWl;
    private b dXZ;
    private com.baidu.swan.games.binding.model.c ebR;
    private com.baidu.swan.games.binding.model.c ebS;
    private com.baidu.swan.games.binding.model.c ebT;
    private c ebU;
    private com.baidu.swan.games.n.b.b ebV;
    private com.baidu.swan.games.n.b.a ebW;
    private com.baidu.swan.games.n.b.a ebX;
    private InterfaceC0546a ebY = new InterfaceC0546a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0546a
        public void mB(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.ebR, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0546a
        public void aYH() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0546a
        public void xK(String str) {
            if (a.this.dXZ != null) {
                a.this.dXZ.xN(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0546a
        public void xL(String str) {
            if (a.this.dXZ != null) {
                a.this.dXZ.xO(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0546a
        public void xM(String str) {
            if (a.this.dXZ != null) {
                a.this.dXZ.xP(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a ebQ = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0546a {
        void aYH();

        void mB(int i);

        void xK(String str);

        void xL(String str);

        void xM(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dXZ = null;
        this.dWl = bVar;
        this.ebQ.a(this.ebY);
        this.dXZ = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.ebV = new com.baidu.swan.games.n.b.b();
        this.ebR = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ebR == null) {
            this.ebR = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dWl == null || this.ebQ == null || this.ebQ.bba()) {
            this.ebV.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ebR, false, this.ebV);
            return;
        }
        this.ebU = new c();
        try {
            if (this.ebU.h(this.ebR)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.bbb().f(a.this.ebQ)) {
                            a.this.ebV.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.ebR, false, a.this.ebV);
                            return;
                        }
                        a.this.ebQ.a(a.this.ebU);
                    }
                }, 500L);
            } else {
                this.ebV.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.ebR, false, this.ebV);
            }
        } catch (JSTypeMismatchException e) {
            this.ebV.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ebR, false, this.ebV);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.ebW = new com.baidu.swan.games.n.b.a();
        this.ebS = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ebS == null) {
            this.ebS = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dWl == null || this.ebQ == null || !this.ebQ.bba()) {
            this.ebW.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ebS, false, this.ebW);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.bbb().g(a.this.ebQ)) {
                    a.this.ebW.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.ebS, true, a.this.ebW);
                    return;
                }
                a.this.ebW.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.ebS, false, a.this.ebW);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.bbb().g(a.this.ebQ);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.ebX = new com.baidu.swan.games.n.b.a();
        this.ebT = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ebT == null) {
            this.ebT = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dWl == null || this.ebQ == null) {
            this.ebX.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.ebT, false, this.ebX);
            return;
        }
        final String optString = this.ebT.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.ebQ.yA(optString)) {
                    a.this.ebX.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.ebT, true, a.this.ebX);
                    return;
                }
                a.this.ebX.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.ebT, false, a.this.ebX);
            }
        });
    }
}
