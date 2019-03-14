package com.baidu.swan.games.j;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.swan.games.e.b aZZ;
    private b baK;
    private com.baidu.swan.games.binding.model.c bdG;
    private com.baidu.swan.games.binding.model.c bdH;
    private com.baidu.swan.games.binding.model.c bdI;
    private c bdJ;
    private com.baidu.swan.games.j.b.b bdK;
    private com.baidu.swan.games.j.b.a bdL;
    private com.baidu.swan.games.j.b.a bdM;
    private InterfaceC0194a bdN = new InterfaceC0194a() { // from class: com.baidu.swan.games.j.a.1
        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void eG(int i) {
            com.baidu.swan.games.j.b.b bVar = new com.baidu.swan.games.j.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.a.a(a.this.bdG, true, bVar);
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void OA() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iL(String str) {
            if (a.this.baK != null) {
                a.this.baK.iO(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iM(String str) {
            if (a.this.baK != null) {
                a.this.baK.iP(str);
            }
        }

        @Override // com.baidu.swan.games.j.a.InterfaceC0194a
        public void iN(String str) {
            if (a.this.baK != null) {
                a.this.baK.iQ(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a bdF = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0194a {
        void OA();

        void eG(int i);

        void iL(String str);

        void iM(String str);

        void iN(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.baK = null;
        this.aZZ = bVar;
        this.bdF.a(this.bdN);
        this.baK = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.bdK = new com.baidu.swan.games.j.b.b();
        this.bdG = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdG == null || this.aZZ == null || this.bdF == null || this.bdF.PI()) {
            this.bdK.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdG, false, this.bdK);
            return;
        }
        this.bdJ = new c();
        try {
            if (this.bdJ.c(this.bdG)) {
                aa.a(new Runnable() { // from class: com.baidu.swan.games.j.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.PJ().f(a.this.bdF)) {
                            a.this.bdK.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.a.a(a.this.bdG, false, a.this.bdK);
                            return;
                        }
                        a.this.bdF.a(a.this.bdJ);
                    }
                }, 500L);
            } else {
                this.bdK.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.a.a(this.bdG, false, this.bdK);
            }
        } catch (JSTypeMismatchException e) {
            this.bdK.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdG, false, this.bdK);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.bdL = new com.baidu.swan.games.j.b.a();
        this.bdH = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdG == null || this.aZZ == null || this.bdF == null || !this.bdF.PI()) {
            this.bdL.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdH, false, this.bdL);
            return;
        }
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.PJ().g(a.this.bdF)) {
                    a.this.bdL.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdH, true, a.this.bdL);
                    return;
                }
                a.this.bdL.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdH, false, a.this.bdL);
            }
        });
    }

    public void hideKeyboard() {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.PJ().g(a.this.bdF);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.bdM = new com.baidu.swan.games.j.b.a();
        this.bdI = com.baidu.swan.games.binding.model.c.b(jsObject) == null ? new com.baidu.swan.games.binding.model.c() : com.baidu.swan.games.binding.model.c.b(jsObject);
        if (this.bdI == null || this.aZZ == null || this.bdF == null) {
            this.bdM.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.a.a(this.bdI, false, this.bdM);
            return;
        }
        final String optString = this.bdI.optString(UBC.CONTENT_KEY_VALUE);
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bdF.jb(optString)) {
                    a.this.bdM.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.a.a(a.this.bdI, true, a.this.bdM);
                    return;
                }
                a.this.bdM.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.a.a(a.this.bdI, false, a.this.bdM);
            }
        });
    }
}
