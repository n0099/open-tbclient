package com.baidu.swan.apps.v.a;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> djU;
    private Runnable djV;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.djU = new ArrayList();
        if (a.aDU()) {
            if (a.aDW()) {
                this.djU.add(new d());
            }
            if (a.aDX()) {
                this.djU.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a aDT() {
        return b.djZ;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.aDU()) {
            this.djV = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.djU) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.djV = null;
                }
            };
            ak.c(this.djV, a.aDV() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.aDU()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.djV != null) {
                            ak.k(c.this.djV);
                            c.this.djV = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.djU) {
                            aVar.onResume();
                        }
                        c.this.mIsPaused = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static int djX = -2;
        private static int djY = -2;

        public static boolean aDU() {
            if (djX == -2) {
                djX = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return djX > -1;
        }

        public static int aDV() {
            return djX;
        }

        public static boolean aDW() {
            if (djY == -2) {
                djY = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_webview_pause_control", 3);
            }
            return (djY & 1) == 1;
        }

        public static boolean aDX() {
            if (djY == -2) {
                djY = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_webview_pause_control", 3);
            }
            return (djY & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private static final c djZ = new c();
    }
}
