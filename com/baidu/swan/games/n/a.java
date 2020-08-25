package com.baidu.swan.games.n;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.swan.games.f.b dox;
    private b dql;
    private com.baidu.swan.games.binding.model.c dug;
    private com.baidu.swan.games.binding.model.c duh;
    private com.baidu.swan.games.binding.model.c dui;
    private c duj;
    private com.baidu.swan.games.n.b.b duk;
    private com.baidu.swan.games.n.b.a dul;
    private com.baidu.swan.games.n.b.a dum;
    private InterfaceC0498a dun = new InterfaceC0498a() { // from class: com.baidu.swan.games.n.a.1
        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void le(int i) {
            com.baidu.swan.games.n.b.b bVar = new com.baidu.swan.games.n.b.b();
            bVar.errMsg = "showKeyboard:ok";
            bVar.height = i;
            com.baidu.swan.games.utils.b.a(a.this.dug, true, bVar);
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void aOw() {
            a.this.hideKeyboard();
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void vv(String str) {
            if (a.this.dql != null) {
                a.this.dql.vy(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void vw(String str) {
            if (a.this.dql != null) {
                a.this.dql.vz(str);
            }
        }

        @Override // com.baidu.swan.games.n.a.InterfaceC0498a
        public void vx(String str) {
            if (a.this.dql != null) {
                a.this.dql.vA(str);
            }
        }
    };
    private Context mContext = AppRuntime.getAppContext();
    private com.baidu.swan.games.view.b.a duf = new com.baidu.swan.games.view.b.a(this.mContext);

    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0498a {
        void aOw();

        void le(int i);

        void vv(String str);

        void vw(String str);

        void vx(String str);
    }

    public a(com.baidu.swan.games.f.b bVar, b bVar2) {
        this.dql = null;
        this.dox = bVar;
        this.duf.a(this.dun);
        this.dql = bVar2;
    }

    public void showKeyboard(JsObject jsObject) {
        this.duk = new com.baidu.swan.games.n.b.b();
        this.dug = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dug == null) {
            this.dug = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dox == null || this.duf == null || this.duf.aQN()) {
            this.duk.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dug, false, this.duk);
            return;
        }
        this.duj = new c();
        try {
            if (this.duj.h(this.dug)) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!com.baidu.swan.games.view.b.b.aQO().f(a.this.duf)) {
                            a.this.duk.errMsg = "showKeyboard:fail";
                            com.baidu.swan.games.utils.b.a(a.this.dug, false, a.this.duk);
                            return;
                        }
                        a.this.duf.a(a.this.duj);
                    }
                }, 500L);
            } else {
                this.duk.errMsg = "showKeyboard:fail";
                com.baidu.swan.games.utils.b.a(this.dug, false, this.duk);
            }
        } catch (JSTypeMismatchException e) {
            this.duk.errMsg = "showKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dug, false, this.duk);
        }
    }

    public void hideKeyboard(JsObject jsObject) {
        this.dul = new com.baidu.swan.games.n.b.a();
        this.duh = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.duh == null) {
            this.duh = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dox == null || this.duf == null || !this.duf.aQN()) {
            this.dul.errMsg = "hideKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.duh, false, this.dul);
            return;
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.games.view.b.b.aQO().g(a.this.duf)) {
                    a.this.dul.errMsg = "hideKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.duh, true, a.this.dul);
                    return;
                }
                a.this.dul.errMsg = "hideKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.duh, false, a.this.dul);
            }
        });
    }

    public void hideKeyboard() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.games.view.b.b.aQO().g(a.this.duf);
            }
        });
    }

    public void updateKeyboard(JsObject jsObject) {
        this.dum = new com.baidu.swan.games.n.b.a();
        this.dui = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dui == null) {
            this.dui = new com.baidu.swan.games.binding.model.c();
        }
        if (this.dox == null || this.duf == null) {
            this.dum.errMsg = "updateKeyboard:fail";
            com.baidu.swan.games.utils.b.a(this.dui, false, this.dum);
            return;
        }
        final String optString = this.dui.optString("value");
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.duf.wl(optString)) {
                    a.this.dum.errMsg = "updateKeyboard:ok";
                    com.baidu.swan.games.utils.b.a(a.this.dui, true, a.this.dum);
                    return;
                }
                a.this.dum.errMsg = "updateKeyboard:fail";
                com.baidu.swan.games.utils.b.a(a.this.dui, false, a.this.dum);
            }
        });
    }
}
