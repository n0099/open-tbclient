package com.baidu.swan.apps.v.a;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> diU;
    private Runnable diV;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.diU = new ArrayList();
        if (a.aAB()) {
            if (a.aAD()) {
                this.diU.add(new d());
            }
            if (a.aAE()) {
                this.diU.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a aAA() {
        return b.diZ;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.aAB()) {
            this.diV = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.diU) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.diV = null;
                }
            };
            ak.c(this.diV, a.aAC() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.aAB()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.diV != null) {
                            ak.i(c.this.diV);
                            c.this.diV = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.diU) {
                            aVar.onResume();
                        }
                        c.this.mIsPaused = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static int diX = -2;
        private static int diY = -2;

        public static boolean aAB() {
            if (diX == -2) {
                diX = com.baidu.swan.apps.t.a.axc().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return diX > -1;
        }

        public static int aAC() {
            return diX;
        }

        public static boolean aAD() {
            if (diY == -2) {
                diY = com.baidu.swan.apps.t.a.axc().getSwitch("swan_webview_pause_control", 3);
            }
            return (diY & 1) == 1;
        }

        public static boolean aAE() {
            if (diY == -2) {
                diY = com.baidu.swan.apps.t.a.axc().getSwitch("swan_webview_pause_control", 3);
            }
            return (diY & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static final c diZ = new c();
    }
}
