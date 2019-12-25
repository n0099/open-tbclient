package com.baidu.swan.games.m;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.games.e.b cfI;
    private b cho;
    private com.baidu.swan.games.binding.model.c cld;
    private com.baidu.swan.games.binding.model.c cle;
    private com.baidu.swan.games.binding.model.c clf;
    private c clg;
    private com.baidu.swan.games.m.b.b clh;
    private com.baidu.swan.games.m.b.a cli;
    private com.baidu.swan.games.m.b.a clj;
    private InterfaceC0327a clk = new InterfaceC0327a() { // from class: com.baidu.swan.games.m.a.1
        @Override // com.baidu.swan.games.m.a.InterfaceC0327a
        public void hC(int i) {
            com.baidu.swan.games.m.b.b bVar = new com.baidu.swan.games.m.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.cld, true, bVar);
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0327a
        public void amd() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0327a
        public void oR(String str) {
            if (a.this.cho != null) {
                a.this.cho.oU(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0327a
        public void oS(String str) {
            if (a.this.cho != null) {
                a.this.cho.oV(str);
            }
        }

        @Override // com.baidu.swan.games.m.a.InterfaceC0327a
        public void oT(String str) {
            if (a.this.cho != null) {
                a.this.cho.oW(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a clc = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0327a {
        void amd();

        void hC(int i);

        void oR(String str);

        void oS(String str);

        void oT(String str);
    }

    public a(com.baidu.swan.games.e.b bVar, b bVar2) {
        this.cho = null;
        this.cfI = bVar;
        this.clc.a(this.clk);
        this.cho = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.clh = new com.baidu.swan.games.m.b.b();
        this.cld = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cld == null) {
            this.cld = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cfI == null || this.clc == null || this.clc.aoj()) {
            this.clh.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cld, false, this.clh);
            return;
        }
        this.clg = new c();
        try {
            if (this.clg.h(this.cld)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aok().f(a.this.clc)) {
                            a.this.clh.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.cld, false, a.this.clh);
                            return;
                        }
                        a.this.clc.a(a.this.clg);
                    }
                }, 500L);
            } else {
                this.clh.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.cld, false, this.clh);
            }
        } catch (JSTypeMismatchException e) {
            this.clh.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cld, false, this.clh);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.cli = new com.baidu.swan.games.m.b.a();
        this.cle = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cle == null) {
            this.cle = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cfI == null || this.clc == null || !this.clc.aoj()) {
            this.cli.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.cle, false, this.cli);
            return;
        }
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aok().g(a.this.clc)) {
                    a.this.cli.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.cle, true, a.this.cli);
                    return;
                }
                a.this.cli.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.cle, false, a.this.cli);
            }
        });
    }

    public void hideKeyboard() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aok().g(a.this.clc);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.clj = new com.baidu.swan.games.m.b.a();
        this.clf = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.clf == null) {
            this.clf = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cfI == null || this.clc == null) {
            this.clj.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.clf, false, this.clj);
            return;
        }
        final String optString = this.clf.optString("value");
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.clc.pC(optString)) {
                    a.this.clj.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.clf, true, a.this.clj);
                    return;
                }
                a.this.clj.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.clf, false, a.this.clj);
            }
        });
    }
}
