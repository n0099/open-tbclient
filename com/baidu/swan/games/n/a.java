package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.games.f.b cYE;
    private b dar;
    private com.baidu.swan.games.binding.model.c deo;
    private com.baidu.swan.games.binding.model.c dep;
    private com.baidu.swan.games.binding.model.c deq;
    private c der;
    private com.baidu.swan.games.n.b.b det;
    private com.baidu.swan.games.n.b.a deu;
    private com.baidu.swan.games.n.b.a dev;
    private InterfaceC0437a dew = new InterfaceC0437a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0437a
        public void iE(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.deo, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0437a
        public void aBY() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0437a
        public void sg(String str) {
            if (a.this.dar != null) {
                a.this.dar.sj(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0437a
        public void sh(String str) {
            if (a.this.dar != null) {
                a.this.dar.sk(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0437a
        public void si(String str) {
            if (a.this.dar != null) {
                a.this.dar.sl(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a den = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0437a {
        void aBY();

        void iE(int i);

        void sg(String str);

        void sh(String str);

        void si(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dar = null;
        this.cYE = bVar;
        this.den.a(this.dew);
        this.dar = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.det = new com.baidu.swan.games.n.b.b();
        this.deo = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.deo == null) {
            this.deo = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cYE == null || this.den == null || this.den.aEe()) {
            this.det.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.deo, false, this.det);
            return;
        }
        this.der = new c();
        try {
            if (this.der.h(this.deo)) {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aEf().f(a.this.den)) {
                            a.this.det.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.deo, false, a.this.det);
                            return;
                        }
                        a.this.den.a(a.this.der);
                    }
                }, 500L);
            } else {
                this.det.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.deo, false, this.det);
            }
        } catch (JSTypeMismatchException e) {
            this.det.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.deo, false, this.det);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.deu = new com.baidu.swan.games.n.b.a();
        this.dep = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dep == null) {
            this.dep = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cYE == null || this.den == null || !this.den.aEe()) {
            this.deu.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dep, false, this.deu);
            return;
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aEf().g(a.this.den)) {
                    a.this.deu.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dep, true, a.this.deu);
                    return;
                }
                a.this.deu.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dep, false, a.this.deu);
            }
        });
    }

    public void hideKeyboard() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aEf().g(a.this.den);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dev = new com.baidu.swan.games.n.b.a();
        this.deq = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.deq == null) {
            this.deq = new com.baidu.swan.games.binding.model.c();
        }
        if (this.cYE == null || this.den == null) {
            this.dev.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.deq, false, this.dev);
            return;
        }
        final String optString = this.deq.optString("value");
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.den.sS(optString)) {
                    a.this.dev.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.deq, true, a.this.dev);
                    return;
                }
                a.this.dev.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.deq, false, a.this.dev);
            }
        });
    }
}
