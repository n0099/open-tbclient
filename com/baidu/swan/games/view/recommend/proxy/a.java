package com.baidu.swan.games.view.recommend.proxy;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.games.view.c;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.b;
import com.baidu.swan.games.view.recommend.a.d;
/* loaded from: classes3.dex */
public class a implements b {
    private b dBP;

    public a(final int i, @NonNull final d dVar, final a.InterfaceC0504a interfaceC0504a) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.1
            @Override // java.lang.Runnable
            public void run() {
                Context aQY = c.aQY();
                if (aQY == null) {
                    com.baidu.swan.apps.console.c.e("RecommendButton", "context is null.");
                    return;
                }
                a.this.dBP = com.baidu.swan.games.view.recommend.a.a.a(i, aQY, dVar);
                a.this.dBP.a(interfaceC0504a);
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final com.baidu.swan.games.view.recommend.model.a aVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBP != null) {
                    a.this.dBP.a(aVar);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final a.InterfaceC0504a interfaceC0504a) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBP != null) {
                    a.this.dBP.a(interfaceC0504a);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void eI(final boolean z) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBP != null) {
                    a.this.dBP.eI(z);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBP != null) {
                    a.this.dBP.show();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBP != null) {
                    a.this.dBP.hide();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBP != null) {
                    a.this.dBP.destroy();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dBP != null) {
                    a.this.dBP.update();
                }
            }
        });
    }
}
