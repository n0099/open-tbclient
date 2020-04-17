package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.e.b cJh;
    private b cKP;
    private com.baidu.swan.games.binding.model.c cOD;
    private com.baidu.swan.games.binding.model.c cOE;
    private com.baidu.swan.games.binding.model.c cOF;
    private c cOG;
    private com.baidu.swan.games.m.b.b cOH;
    private com.baidu.swan.games.m.b.a cOI;
    private com.baidu.swan.games.m.b.a cOJ;
    private InterfaceC0369a cOK = new InterfaceC0369a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0369a
        public void ia(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cOD, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0369a
        public void axb() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0369a
        public void qv(String str) {
            if (a.this.cKP != null) {
                a.this.cKP.qy(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0369a
        public void qw(String str) {
            if (a.this.cKP != null) {
                a.this.cKP.qz(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0369a
        public void qx(String str) {
            if (a.this.cKP != null) {
                a.this.cKP.qA(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a cOC = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0369a {
        void axb();

        void ia(int i);

        void qv(String str);

        void qw(String str);

        void qx(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.cKP = null;
        this.cJh = bVar;
        this.cOC.a(this.cOK);
        this.cKP = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.cOH = new com.baidu.swan.games.m.b.b();
        this.cOD = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cOD == null) {
            this.cOD = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cJh == null || this.cOC == null || this.cOC.azg()) {
            this.cOH.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOD, false, this.cOH);
            return;
        }
        this.cOG = new c();
        try {
            if (this.cOG.h(this.cOD)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.azh().f(a.this.cOC)) {
                            a.this.cOH.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cOD, false, a.this.cOH);
                            return;
                        }
                        a.this.cOC.a(a.this.cOG);
                    }
                }, 500L);
            } else {
                this.cOH.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cOD, false, this.cOH);
            }
        } catch (JSTypeMismatchException e) {
            this.cOH.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOD, false, this.cOH);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cOI = new com.baidu.swan.games.m.b.a();
        this.cOE = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cOE == null) {
            this.cOE = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cJh == null || this.cOC == null || !this.cOC.azg()) {
            this.cOI.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOE, false, this.cOI);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.azh().g(a.this.cOC)) {
                    a.this.cOI.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cOE, true, a.this.cOI);
                    return;
                }
                a.this.cOI.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cOE, false, a.this.cOI);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.azh().g(a.this.cOC);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.cOJ = new com.baidu.swan.games.m.b.a();
        this.cOF = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cOF == null) {
            this.cOF = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cJh == null || this.cOC == null) {
            this.cOJ.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cOF, false, this.cOJ);
            return;
        }
        final String optString = this.cOF.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cOC.rg(optString)) {
                    a.this.cOJ.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cOF, true, a.this.cOJ);
                    return;
                }
                a.this.cOJ.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cOF, false, a.this.cOJ);
            }
        });
    }
}
