package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b doB;
    private b dqp;
    private com.baidu.swan.games.binding.model.c duk;
    private com.baidu.swan.games.binding.model.c dul;
    private com.baidu.swan.games.binding.model.c dum;
    private c dun;
    private com.baidu.swan.games.n.b.b duo;
    private com.baidu.swan.games.n.b.a dup;
    private com.baidu.swan.games.n.b.a duq;
    private InterfaceC0498a dur = new InterfaceC0498a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void le(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.duk, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void aOw() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void vw(String str) {
            if (a.this.dqp != null) {
                a.this.dqp.vz(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void vx(String str) {
            if (a.this.dqp != null) {
                a.this.dqp.vA(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void vy(String str) {
            if (a.this.dqp != null) {
                a.this.dqp.vB(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a duj = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0498a {
        void aOw();

        void le(int i);

        void vw(String str);

        void vx(String str);

        void vy(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dqp = null;
        this.doB = bVar;
        this.duj.a(this.dur);
        this.dqp = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.duo = new com.baidu.swan.games.n.b.b();
        this.duk = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.duk == null) {
            this.duk = new com.baidu.swan.games.binding.model.c();
        }
        if (this.doB == null || this.duj == null || this.duj.aQN()) {
            this.duo.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.duk, false, this.duo);
            return;
        }
        this.dun = new c();
        try {
            if (this.dun.h(this.duk)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aQO().f(a.this.duj)) {
                            a.this.duo.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.duk, false, a.this.duo);
                            return;
                        }
                        a.this.duj.a(a.this.dun);
                    }
                }, 500L);
            } else {
                this.duo.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.duk, false, this.duo);
            }
        } catch (JSTypeMismatchException e) {
            this.duo.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.duk, false, this.duo);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dup = new com.baidu.swan.games.n.b.a();
        this.dul = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dul == null) {
            this.dul = new com.baidu.swan.games.binding.model.c();
        }
        if (this.doB == null || this.duj == null || !this.duj.aQN()) {
            this.dup.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dul, false, this.dup);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aQO().g(a.this.duj)) {
                    a.this.dup.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dul, true, a.this.dup);
                    return;
                }
                a.this.dup.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dul, false, a.this.dup);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aQO().g(a.this.duj);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.duq = new com.baidu.swan.games.n.b.a();
        this.dum = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dum == null) {
            this.dum = new com.baidu.swan.games.binding.model.c();
        }
        if (this.doB == null || this.duj == null) {
            this.duq.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dum, false, this.duq);
            return;
        }
        final String optString = this.dum.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.duj.wm(optString)) {
                    a.this.duq.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dum, true, a.this.duq);
                    return;
                }
                a.this.duq.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dum, false, a.this.duq);
            }
        });
    }
}
