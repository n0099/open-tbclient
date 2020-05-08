package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cJn;
    private b cKV;
    private com.baidu.swan.games.binding.model.c cOI;
    private com.baidu.swan.games.binding.model.c cOJ;
    private com.baidu.swan.games.binding.model.c cOK;
    private c cOL;
    private com.baidu.swan.games.m.b.b cOM;
    private com.baidu.swan.games.m.b.a cON;
    private com.baidu.swan.games.m.b.a cOO;
    private InterfaceC0390a cOP = new InterfaceC0390a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0390a
        public void ia(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cOI, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0390a
        public void axb() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0390a
        public void qv(String str) {
            if (a.this.cKV != null) {
                a.this.cKV.qy(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0390a
        public void qw(String str) {
            if (a.this.cKV != null) {
                a.this.cKV.qz(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0390a
        public void qx(String str) {
            if (a.this.cKV != null) {
                a.this.cKV.qA(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a cOH = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0390a {
        void axb();

        void ia(int i);

        void qv(String str);

        void qw(String str);

        void qx(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.cKV = null;
        this.cJn = bVar;
        this.cOH.a(this.cOP);
        this.cKV = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.cOM = new com.baidu.swan.games.m.b.b();
        this.cOI = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cOI == null) {
            this.cOI = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cJn == null || this.cOH == null || this.cOH.azg()) {
            this.cOM.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOI, false, this.cOM);
            return;
        }
        this.cOL = new c();
        try {
            if (this.cOL.h(this.cOI)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.azh().f(a.this.cOH)) {
                            a.this.cOM.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cOI, false, a.this.cOM);
                            return;
                        }
                        a.this.cOH.a(a.this.cOL);
                    }
                }, 500L);
            } else {
                this.cOM.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cOI, false, this.cOM);
            }
        } catch (JSTypeMismatchException e) {
            this.cOM.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOI, false, this.cOM);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cON = new com.baidu.swan.games.m.b.a();
        this.cOJ = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cOJ == null) {
            this.cOJ = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cJn == null || this.cOH == null || !this.cOH.azg()) {
            this.cON.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOJ, false, this.cON);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.azh().g(a.this.cOH)) {
                    a.this.cON.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cOJ, true, a.this.cON);
                    return;
                }
                a.this.cON.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cOJ, false, a.this.cON);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.azh().g(a.this.cOH);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.cOO = new com.baidu.swan.games.m.b.a();
        this.cOK = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cOK == null) {
            this.cOK = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cJn == null || this.cOH == null) {
            this.cOO.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOK, false, this.cOO);
            return;
        }
        final String optString = this.cOK.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cOH.rg(optString)) {
                    a.this.cOO.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cOK, true, a.this.cOO);
                    return;
                }
                a.this.cOO.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cOK, false, a.this.cOO);
            }
        });
    }
}
