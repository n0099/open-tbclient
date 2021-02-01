package com.baidu.swan.apps.v.a;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> dhq;
    private Runnable dhr;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.dhq = new ArrayList();
        if (a.aAy()) {
            if (a.aAA()) {
                this.dhq.add(new d());
            }
            if (a.aAB()) {
                this.dhq.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a aAx() {
        return b.dhv;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.aAy()) {
            this.dhr = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.dhq) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.dhr = null;
                }
            };
            ak.c(this.dhr, a.aAz() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.aAy()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.dhr != null) {
                            ak.j(c.this.dhr);
                            c.this.dhr = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.dhq) {
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
        private static int dht = -2;
        private static int dhu = -2;

        public static boolean aAy() {
            if (dht == -2) {
                dht = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return dht > -1;
        }

        public static int aAz() {
            return dht;
        }

        public static boolean aAA() {
            if (dhu == -2) {
                dhu = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_webview_pause_control", 3);
            }
            return (dhu & 1) == 1;
        }

        public static boolean aAB() {
            if (dhu == -2) {
                dhu = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_webview_pause_control", 3);
            }
            return (dhu & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b {
        private static final c dhv = new c();
    }
}
