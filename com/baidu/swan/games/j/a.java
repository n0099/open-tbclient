package com.baidu.swan.games.j;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b aZY;
    private b baJ;
    private com.baidu.swan.games.binding.model.c bdF;
    private com.baidu.swan.games.binding.model.c bdG;
    private com.baidu.swan.games.binding.model.c bdH;
    private c bdI;
    private com.baidu.swan.games.j.b.b bdJ;
    private com.baidu.swan.games.j.b.a bdK;
    private com.baidu.swan.games.j.b.a bdL;
    private InterfaceC0165a bdM = new InterfaceC0165a() { // from class: com.baidu.swan.games.j.a.1
        @Override // com.baidu.swan.games.j.a.InterfaceC0165a
        public void eG(int i) {
            com.baidu.swan.games.j.b.b bVar = new com.baidu.swan.games.j.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bdF, true, bVar);
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0165a
        public void OA() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0165a
        public void iL(String str) {
            if (a.this.baJ != null) {
                a.this.baJ.iO(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0165a
        public void iM(String str) {
            if (a.this.baJ != null) {
                a.this.baJ.iP(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0165a
        public void iN(String str) {
            if (a.this.baJ != null) {
                a.this.baJ.iQ(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bdE = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0165a {
        void OA();

        void eG(int i);

        void iL(String str);

        void iM(String str);

        void iN(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.baJ = null;
        this.aZY = bVar;
        this.bdE.a(this.bdM);
        this.baJ = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bdJ = new com.baidu.swan.games.j.b.b();
        this.bdF = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdF == null || this.aZY == null || this.bdE == null || this.bdE.PI()) {
            this.bdJ.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdF, false, this.bdJ);
            return;
        }
        this.bdI = new c();
        try {
            if (this.bdI.c(this.bdF)) {
                aa.a(new Runnable() { // from class: com.baidu.swan.games.j.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.PJ().f(a.this.bdE)) {
                            a.this.bdJ.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bdF, false, a.this.bdJ);
                            return;
                        }
                        a.this.bdE.a(a.this.bdI);
                    }
                }, 500L);
            } else {
                this.bdJ.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bdF, false, this.bdJ);
            }
        } catch (JSTypeMismatchException e) {
            this.bdJ.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdF, false, this.bdJ);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bdK = new com.baidu.swan.games.j.b.a();
        this.bdG = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdF == null || this.aZY == null || this.bdE == null || !this.bdE.PI()) {
            this.bdK.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdG, false, this.bdK);
            return;
        }
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.PJ().g(a.this.bdE)) {
                    a.this.bdK.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdG, true, a.this.bdK);
                    return;
                }
                a.this.bdK.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdG, false, a.this.bdK);
            }
        });
    }

    public void hideKeyboard() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.PJ().g(a.this.bdE);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bdL = new com.baidu.swan.games.j.b.a();
        this.bdH = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdH == null || this.aZY == null || this.bdE == null) {
            this.bdL.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdH, false, this.bdL);
            return;
        }
        final String optString = this.bdH.optString(UBC.CONTENT_KEY_VALUE);
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bdE.jb(optString)) {
                    a.this.bdL.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdH, true, a.this.bdL);
                    return;
                }
                a.this.bdL.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdH, false, a.this.bdL);
            }
        });
    }
}
