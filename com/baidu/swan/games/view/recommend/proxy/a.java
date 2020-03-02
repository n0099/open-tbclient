package com.baidu.swan.games.view.recommend.proxy;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.games.view.c;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.b;
import com.baidu.swan.games.view.recommend.a.d;
/* loaded from: classes11.dex */
public class a implements b {
    private b cuM;

    public a(final int i, @NonNull final d dVar, final a.InterfaceC0350a interfaceC0350a) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.1
            @Override // java.lang.Runnable
            public void run() {
                Context aqr = c.aqr();
                if (aqr == null) {
                    com.baidu.swan.apps.console.c.e("RecommendButton", "context is null.");
                    return;
                }
                a.this.cuM = com.baidu.swan.games.view.recommend.a.a.a(i, aqr, dVar);
                a.this.cuM.a(interfaceC0350a);
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final com.baidu.swan.games.view.recommend.model.a aVar) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuM != null) {
                    a.this.cuM.a(aVar);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void a(final a.InterfaceC0350a interfaceC0350a) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuM != null) {
                    a.this.cuM.a(interfaceC0350a);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void cS(final boolean z) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuM != null) {
                    a.this.cuM.cS(z);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void show() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuM != null) {
                    a.this.cuM.show();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void hide() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuM != null) {
                    a.this.cuM.hide();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a
    public void destroy() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.7
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuM != null) {
                    a.this.cuM.destroy();
                }
            }
        });
    }

    @Override // com.baidu.swan.games.view.recommend.a.b
    public void update() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuM != null) {
                    a.this.cuM.update();
                }
            }
        });
    }
}
