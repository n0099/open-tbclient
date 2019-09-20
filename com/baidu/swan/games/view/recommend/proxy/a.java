package com.baidu.swan.games.view.recommend.proxy;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.b;
import com.baidu.swan.games.view.recommend.a.d;
/* loaded from: classes2.dex */
public class a implements b {
    private b bnF;

    public a(final int i, @NonNull final d dVar, final a.InterfaceC0229a interfaceC0229a) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.1
            @Override // java.lang.Runnable
            public void run() {
                Context TB = com.baidu.swan.games.view.a.TB();
                if (TB == null) {
                    c.e("RecommendButton", "context is null.");
                    return;
                }
                a.this.bnF = com.baidu.swan.games.view.recommend.a.a.a(i, TB, dVar);
                a.this.bnF.a(interfaceC0229a);
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final com.baidu.swan.games.view.recommend.d.b bVar) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bnF != null) {
                    a.this.bnF.a(bVar);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final a.InterfaceC0229a interfaceC0229a) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bnF != null) {
                    a.this.bnF.a(interfaceC0229a);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void by(final boolean z) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bnF != null) {
                    a.this.bnF.by(z);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bnF != null) {
                    a.this.bnF.show();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bnF != null) {
                    a.this.bnF.hide();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bnF != null) {
                    a.this.bnF.destroy();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.bnF != null) {
                    a.this.bnF.update();
                }
            }
        });
    }
}
