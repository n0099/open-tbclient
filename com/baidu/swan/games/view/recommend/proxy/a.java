package com.baidu.swan.games.view.recommend.proxy;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.games.view.c;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.b;
import com.baidu.swan.games.view.recommend.a.d;
/* loaded from: classes7.dex */
public class a implements b {
    private b dpI;

    public a(final int i, @NonNull final d dVar, final a.InterfaceC0461a interfaceC0461a) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.1
            @Override // java.lang.Runnable
            public void run() {
                Context aHu = c.aHu();
                if (aHu == null) {
                    com.baidu.swan.apps.console.c.e("RecommendButton", "context is null.");
                    return;
                }
                a.this.dpI = com.baidu.swan.games.view.recommend.a.a.a(i, aHu, dVar);
                a.this.dpI.a(interfaceC0461a);
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final com.baidu.swan.games.view.recommend.model.a aVar) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpI != null) {
                    a.this.dpI.a(aVar);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final a.InterfaceC0461a interfaceC0461a) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpI != null) {
                    a.this.dpI.a(interfaceC0461a);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void et(final boolean z) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpI != null) {
                    a.this.dpI.et(z);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpI != null) {
                    a.this.dpI.show();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpI != null) {
                    a.this.dpI.hide();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpI != null) {
                    a.this.dpI.destroy();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpI != null) {
                    a.this.dpI.update();
                }
            }
        });
    }
}
